%% Record definition for client state
-record(client_state, {
    server_pid,
    client_id
}).

%% Record definition for server state
-record(server_state, {
    clients = []
}).

%% Record definition for router state
-record(router_state, {
    servers,
    server_monitor
}).

%% Macro for maximum number of retries on failure
-define(MAX_RETRIES, 3).

%% Macro for log messages
-define(LOG(Message), io:format("~p - ~s~n", [erlang:now(), Message])).
