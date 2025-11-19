-module(client).
-behaviour(gen_server).

%% Include the shared header file
-include("../include/config.hrl").

%% API
-export([start_link/0, join_server/1, leave_server/0, send_message/1]).

%% gen_server callbacks
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2, code_change/3]).

%%% Public API %%%

% Starts the client process
start_link() ->
    io:format("Starting client process...~n"),
    gen_server:start_link({local, client}, client, [], []).

% Requests to join a server
join_server(ServerPid) ->
    io:format("Requesting to join server~n"),
    gen_server:call(client, {join, ServerPid}).

% Leaves the server
leave_server() ->
    io:format("Leaving the server~n"),
    gen_server:call(client, leave).

% Sends a message to the server
send_message(Msg) ->
    io:format("Sending message: ~p~n", [Msg]),
    gen_server:cast(client, {send, Msg}).

%%% gen_server callbacks %%%

% Initializes the client state
init([]) ->
    {ok, #client_state{server_pid = undefined, client_id = undefined}}.

% Handles a join request response from the server
handle_call({join, ServerPid}, _From, State) ->
    % Generates a unique client ID
    ClientId = erlang:make_ref(),
    io:format("Joining server with ClientId: ~p~n", [ClientId]),
    % Notifies the server about the join request
    ServerPid ! {join, self(), ClientId},
    {reply, ok, State#client_state{server_pid = ServerPid, client_id = ClientId}};

% Handles a leave request response from the server
handle_call(leave, _From, State = #client_state{server_pid = ServerPid, client_id = ClientId}) ->
    io:format("Leaving server with ClientId: ~p~n", [ClientId]),
    % Notifies the server about the leave request
    ServerPid ! {leave, ClientId},
    {reply, ok, State#client_state{server_pid = undefined, client_id = undefined}};

% Handles other call requests
handle_call(_Request, _From, State) ->
    {reply, ok, State}.

% Handles a message sent from the client
handle_cast({send, Msg}, State = #client_state{server_pid = ServerPid, client_id = ClientId}) when is_pid(ServerPid) ->
    io:format("Sending message ~p to server~n", [Msg]),
    % Sends the message to the server
    ServerPid ! {message, ClientId, Msg},
    {noreply, State};

% Handles other cast messages
handle_cast(_Msg, State) ->
    {noreply, State}.

% Handles a message received from the server
handle_info({message, Msg}, State) ->
    io:format("Received message: ~p~n", [Msg]),
    {noreply, State};

% Handles other unexpected info messages
handle_info(Info, State) ->
    io:format("Received unknown info: ~p~n", [Info]),
    {noreply, State}.

% Handles termination of the client
terminate(_Reason, _State) ->
    ok.

% Handles code changes (not used in this example)
code_change(_OldVsn, State, _Extra) ->
    {ok, State}.
