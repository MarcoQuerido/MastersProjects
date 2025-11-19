% Start Erlang nodes
$ erl -sname node_router
$ erl -sname node_server
$ erl -sname node_client

% Compile the modules
c("client").
% {ok,client}
c("server").
% {ok,server}
c("router").
% {ok,router}

% start modules
router:start(router1)
server:start(server1)
client:start(client1)
client:start(client2)

% connect to other modules
client:add_remote(server1)