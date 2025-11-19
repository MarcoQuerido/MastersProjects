-module(server).
-behaviour(gen_server).

%% Include the shared header file
-include("../include/config.hrl").

%% API
-export([start_link/0, join/2, leave/1, send_message/2]).

%% gen_server callbacks
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2, code_change/3]).

%%% Public API %%%

% Starts the server process
start_link() ->
    io:format("Starting server process...~n"),
    gen_server:start_link({local, server}, server, [], []).

% Allows a client to join the server
join(ClientPid, ClientId) ->
    io:format("Client with PID ~p joining server with ID ~p...~n", [ClientPid, ClientId]),
    gen_server:call(server, {join, ClientPid, ClientId}).

% Allows a client to leave the server
leave(ClientId) ->
    io:format("Client with ID ~p leaving server...~n", [ClientId]),
    gen_server:call(server, {leave, ClientId}).

% Sends a message to a client
send_message(ClientId, Msg) ->
    io:format("Sending message ~p to client with ID ~p...~n", [Msg, ClientId]),
    gen_server:cast(server, {message, ClientId, Msg}).

%%% gen_server callbacks %%%

% Initializes the server state
init([]) ->
    {ok, #server_state{clients = []}}.

% Handles a client's join request
handle_call({join, ClientPid, ClientId}, _From, #server_state{clients = Clients} = State) ->
    NewClients = [{ClientId, ClientPid} | Clients],
    io:format("Client with ID ~p joined. Total clients: ~p~n", [ClientId, length(NewClients)]),
    {reply, ok, State#server_state{clients = NewClients}};

% Handles a client's leave request
handle_call({leave, ClientId}, _From, #server_state{clients = Clients} = State) ->
    NewClients = lists:filter(fun({Id, _}) -> Id =/= ClientId end, Clients),
    io:format("Client with ID ~p left. Total clients: ~p~n", [ClientId, length(NewClients)]),
    {reply, ok, State#server_state{clients = NewClients}};

% Handles other call requests
handle_call(_Request, _From, State) ->
    {reply, ok, State}.

% Handles a message sent from a client
handle_cast({message, ClientId, Msg}, #server_state{clients = Clients} = State) ->
    io:format("Server received message ~p from client ~p~n", [Msg, ClientId]),
    lists:foreach(fun({_Id, Pid}) ->
        Pid ! {message, Msg}  % Send the message to all clients
    end, Clients),
    {noreply, State};

% Handles other cast messages
handle_cast(_Msg, State) ->
    {noreply, State}.

% Handles a join message from a client
handle_info({join, ClientPid, ClientId}, #server_state{clients = Clients} = State) ->
    NewClients = [{ClientId, ClientPid} | Clients],
    io:format("Client with ID ~p joined. Total clients: ~p~n", [ClientId, length(NewClients)]),
    {noreply, State#server_state{clients = NewClients}};

% Handles a message received from a client
handle_info({message, ClientId, Msg}, State) ->
    io:format("Received message ~p from client ~p~n", [Msg, ClientId]),
    {noreply, State};

% Handles a leave message from a client
handle_info({leave, ClientId}, #server_state{clients = Clients} = State) ->
    NewClients = lists:filter(fun({Id, _}) -> Id =/= ClientId end, Clients),
    io:format("Client with ID ~p left. Total clients: ~p~n", [ClientId, length(NewClients)]),
    {noreply, State#server_state{clients = NewClients}};

% Handles other unexpected info messages
handle_info(Info, State) ->
    io:format("Received unknown info: ~p~n", [Info]),
    {noreply, State}.

% Handles termination of the server
terminate(_Reason, _State) ->
    ok.

% Handles code changes (not used in this example)
code_change(_OldVsn, State, _Extra) ->
    {ok, State}.
