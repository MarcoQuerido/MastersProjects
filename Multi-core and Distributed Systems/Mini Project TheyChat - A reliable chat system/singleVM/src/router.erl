-module(router).
-behaviour(gen_server).

%% Include the shared header file
-include("../include/config.hrl").

%% API
-export([start_link/0, assign_server/1, monitor_server/1, handle_failure/1, start_and_monitor_server/0]).

%% gen_server callbacks
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2, code_change/3]).

%%% Public API %%%

% Starts the router process
%start_link() ->
%    io:format("Starting router process...~n"),
%    gen_server:start_link({local, router}, router, [], []).
start_link() ->
    case whereis(router) of
        undefined ->
            {ok, Pid} = gen_server:start_link({local, router}, router, [], []),
            {ok, Pid};
        Pid ->
            {ok, Pid}
    end.

% Assigns a server to a client
assign_server(ClientPid) ->
    io:format("Assigning server to client with PID ~p...~n", [ClientPid]),
    gen_server:call(router, {assign, ClientPid}).

% Monitors a server
monitor_server(ServerPid) ->
    io:format("Monitoring server with PID ~p...~n", [ServerPid]),
    gen_server:cast(router, {monitor, ServerPid}).

% Handles failure of a server
handle_failure(ServerPid) ->
    io:format("Handling failure of server with PID ~p...~n", [ServerPid]),
    gen_server:cast(router, {failure, ServerPid}).

% Starts and monitors a server
start_and_monitor_server() ->
    {ok, ServerPid} = start_server(),
    monitor_server(ServerPid),
    {ok, ServerPid}.

%%% gen_server callbacks %%%

% Initializes the router state
init([]) ->
    % Spawns a server monitor process
    ServerMonitor = spawn_link(fun monitor_servers/0),
    {ok, #router_state{servers = [], server_monitor = ServerMonitor}}.

% Handles a request to assign a server to a client
handle_call({assign, ClientPid}, _From, #router_state{servers = Servers} = State) ->
    {ServerPid, NewServers} = assign_to_server(Servers),
    io:format("Client with PID ~p assigned to server with PID ~p~n", [ClientPid, ServerPid]),
    % Notifies the server about the new client
    ServerPid ! {new_client, ClientPid},
    {reply, ServerPid, State#router_state{servers = NewServers}};

% Handles other call requests
handle_call(_Request, _From, State) ->
    {reply, ok, State}.

% Handles a monitor request for a server
handle_cast({monitor, ServerPid}, #router_state{server_monitor = Monitor} = State) ->
    Monitor ! {monitor, ServerPid},
    {noreply, State};

% Handles a failure notification for a server
handle_cast({failure, ServerPid}, #router_state{servers = Servers} = State) ->
    % Restarts the failed server
    {ok, RestartedServerPid} = start_server(),
    io:format("Server with PID ~p failed. Restarted with PID ~p~n", [ServerPid, RestartedServerPid]),
    % Updates the list of servers with the restarted server
    NewServers = lists:map(fun(Pid) -> if Pid =:= ServerPid -> RestartedServerPid; true -> Pid end end, Servers),
    {noreply, State#router_state{servers = NewServers}};

% Handles other cast messages
handle_cast(_Msg, State) ->
    {noreply, State}.

% Handles general info messages
handle_info(_Info, State) ->
    {noreply, State}.

% Handles termination of the router
terminate(_Reason, _State) ->
    ok.

% Handles code changes (not used in this example)
code_change(_OldVsn, State, _Extra) ->
    {ok, State}.

%%% Internal Functions %%%

% Assigns a server to a client
assign_to_server(Servers) ->
    % Example logic for assigning a server
    case Servers of
        [] ->
            % If no servers are available, start a new one
            {ok, Pid} = start_server(),
            {Pid, [Pid]};  % return the Pid and update the list
        [H|_] ->
            % Otherwise, return the head of the list which is the Pid
            {H, Servers}
    end.

% Starts a new server
start_server() ->
    {ok, Pid} = server:start_link(),
    {ok, Pid}.

% Monitors the servers for failures
monitor_servers() ->
    receive
        {monitor, ServerPid} ->
            % Sets up monitoring for the server
            process_flag(trap_exit, true),
            link(ServerPid),
            monitor_servers();
        {'EXIT', ServerPid, _Reason} ->
            % Handles the failure of a server
            router ! {failure, ServerPid},
            monitor_servers()
    end.
