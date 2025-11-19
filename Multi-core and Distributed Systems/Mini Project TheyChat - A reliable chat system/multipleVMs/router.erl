-module(router).
-export([start/0, register_client/1, send_to_server/4, stop/0]).

start() ->
    Clients = dict:new(),
    loop(Clients).

loop(Clients) ->
    receive
        {register, Client, ClientPid} ->
            NewClients = dict:store(Client, ClientPid, Clients),
            loop(NewClients);
        {send_to_server, Client, Server, RemoteMachine, Message} ->
            case dict:find(Client, Clients) of
                {ok, ClientPid} ->
                    ClientPid ! {send, Server, RemoteMachine, Message},
                    loop(Clients);
                error ->
                    io:format("Error: Client ~p not found~n", [Client]),
                    loop(Clients)
            end;
        stop ->
            io:format("Router exiting...~n")
    end.

register_client(Client) ->
    Router = whereis(router),
    Router ! {register, Client, self()}.

send_to_server(Client, Server, RemoteMachine, Message) ->
    Router = whereis(router),
    Router ! {send_to_server, Client, Server, RemoteMachine, Message}.

stop() ->
    Router = whereis(router),
    Router ! stop.
