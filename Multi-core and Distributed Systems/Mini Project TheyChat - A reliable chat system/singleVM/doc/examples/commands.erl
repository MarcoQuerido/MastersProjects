% Start Erlang shell
$ erl

% Compile the modules
c("client").
% {ok,client}
c("server").
% {ok,server}
c("router").
% {ok,router}

% Start the router
router:start_link().

% Start a server and inform the router
server:start_link().
router:monitor_server().
or 
router:start_and_monitor_server().

% Start a client and join the server
client:start_link().
client:join_server(ServerPid).
ex : client:join_server(<0.145.0>).
% Requesting to join server
% Joining server with ClientId: #Ref<0.2478485076.872153093.139918>
ok
% Handling join request from client with ID #Ref<0.2478485076.872153093.139918> and PID <0.147.0>
% Client with ID #Ref<0.2478485076.872153093.139918> joined. Total clients: 1

% Send a message from the client
client:send_message("Hello, Server!").
% Sending message: "Hello, Server!"
% Sending message "Hello, Server!" to server
ok
% 
% Server received message "Hello, Server!" from client #Ref<0.2478485076.872153093.139918>

% Leave the server 
client:leave_server().
% Leaving the server
% Leaving server with ClientId: #Ref<0.2478485076.872153093.139918>
ok
% Client with ID #Ref<0.2478485076.872153093.139918> left. Total clients: 0


% Test the monitors
c("router_module").
c("router_monitor").
c("server_module").

% Start the supervisor for the router monitor
router_monitor:start_link().

% Start the supervisor for the server
server_module:start_link().

% Check the status of the supervision trees
supervisor:which_children(router_monitor).
ex : supervisor:which_children(<0.189.0>).

supervisor:which_children(server_module).
ex : supervisor:which_children(<0.193.0>).

% simulate crash of the router process
exit(whereis(router), kill).

% check the status of the supervision tree again
supervisor:which_children(router_monitor).
% true
%Starting router process...
%=SUPERVISOR REPORT==== 25-May-2024::17:40:44.697000 ===
%    supervisor: {local,router_monitor}
%    errorContext: child_terminated
%    reason: killed
%    offender: [{pid,<0.220.0>},
%               {id,router},
%               {mfargs,{router,start_link,[]}},
%               {restart_type,permanent},
%               {significant,false},
%               {shutdown,5000},
%               {child_type,worker}]
supervisor:which_children(<0.219.0>).
% [{router,<0.225.0>,worker,[router]}]
% router restarted !

% simulate failure of the server process
exit(whereis(server), kill).
% true
%Starting server process...
%=SUPERVISOR REPORT==== 25-May-2024::17:49:35.244000 ===
%    supervisor: {local,server_module}
%    errorContext: child_terminated
%    reason: killed
%    offender: [{pid,<0.231.0>},
%               {id,server},
%               {mfargs,{server,start_link,[]}},
%               {restart_type,permanent},
%               {significant,false},
%               {shutdown,5000},
%               {child_type,worker}]
supervisor:which_children(<0.230.0>).
% [{server,<0.235.0>,worker,[server]}]
% server restarted !