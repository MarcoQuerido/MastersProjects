-module(client).
-export([start/1, add_remote/1, send_msg/4, stop_client/1, loop/0]).

start(Client) ->
    register(Client, spawn(?MODULE, loop, [])).

loop() ->
    receive
        {send, Server, RemoteMachine, Message} ->
            Router = whereis(router),
            Router ! {send_to_server, self(), Server, RemoteMachine, Message},
            loop();
        {stop_client} ->
            io:format("Client exiting...~n");
        Other ->
            io:format("Unknown message: ~p~n", [Other]),
            loop()
    end.

add_remote(RemoteMachine) ->
    net_adm:ping(RemoteMachine).

send_msg(Client, Server, RemoteMachine, Message) ->
    Client ! {send, Server, RemoteMachine, Message}.

stop_client(Client) ->
    Client ! {stop_client}.
