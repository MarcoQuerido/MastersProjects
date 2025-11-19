-module(heychat_test).
-include_lib("eunit/include/eunit.hrl").

% Define test functions
% erl -noshell -pa ../src -eval "eunit:test(heychat_test2, [verbose]), init:stop()."

test_router_start_and_monitor_test() ->
    router:start_link(),
    ?assert(router:monitor_server(self()) =:= ok),
    gen_server:cast(router, terminate).

test_router_start_and_monitor_server_test() ->
    router:start_and_monitor_server(),
    ?assert(true),
    gen_server:cast(server, terminate).

test_router_module_start_link_test() ->
    router:start_link(),
    ?assert(true),
    gen_server:cast(router, terminate).

test_server_module_start_link_test() ->
    server:start_link(),
    ?assert(true),
    gen_server:cast(server, terminate).

test_router_handle_failure_test() ->
    router:start_link(),
    ServerPid = erlang:spawn(fun() -> receive _Any -> ok end end),
    try
        ?assert(router:handle_failure(ServerPid) =:= ok)
    after
        exit(ServerPid, shutdown)
    end,
    gen_server:cast(router, terminate).

test_start_and_join_server_test() ->
    server:start_link(),
    client:start_link(),
    ServerPid = erlang:spawn(fun() -> receive _Any -> ok end end),
    client:join_server(ServerPid).

test_send_message_to_client_test() ->
    server:start_link(),
    ServerPid = erlang:spawn(fun() -> receive _Any -> ok end end),
    client:start_link(),
    client:join_server(ServerPid),
    Msg = "Hello, client!",
    client:send_message(Msg),
    gen_server:cast(client, terminate),
    gen_server:cast(server, terminate).

test_leave_server_test() ->
    server:start_link(),
    ServerPid = erlang:spawn(fun() -> receive _Any -> ok end end),
    client:start_link(),
    client:join_server(ServerPid),
    client:leave_server().

test_router_assign_server_test() ->
    {ok, RouterPid} = router:start_link(),
    ClientPid = erlang:self(),
    try
        {ok, ServerPid} = router:assign_server(ClientPid),
        ?assert(ServerPid /= undefined)
    after
        exit(RouterPid, shutdown)
    end.


test_monitor_servers_test() ->
    {ok, MonitorPid} = erlang:spawn_link(fun router_monitor:monitor_servers/0),
    ServerPid = erlang:spawn(fun() -> receive _Any -> ok end end),
    try
        MonitorPid ! {monitor, ServerPid},
        receive
            {failure, _} ->
                true
        after 2000 ->
            false
        end
    after
        exit(MonitorPid, shutdown),
        exit(ServerPid, shutdown)
    end.
