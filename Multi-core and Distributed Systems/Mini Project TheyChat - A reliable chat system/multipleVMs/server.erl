-module(server).
-export([start/1, loop/0]).

start(Server) ->
    register(Server, spawn(?MODULE, loop, [])).

loop() ->
    receive
        {send, Server, RemoteMachine, Message} ->
            {Server, RemoteMachine} ! {self(), Message},
            receive
                {_, Reply} -> io:format("Received from server: ~p~n", [Reply])
            end,
            loop();
        stop ->
            io:format("Server exiting...~n")
    end.
