-module(server_module).
-behaviour(supervisor).

-export([start_link/0]).
-export([init/1]).

% Starts the supervisor process
start_link() ->
    supervisor:start_link({local, ?MODULE}, ?MODULE, []).

% Initializes the supervisor with child specifications
init([]) ->
    {ok, {{one_for_one, 3, 3600},  % Supervisor strategy: restarts failed children one by one, maximum 3 restarts in 3600 seconds
      [
        % Child specification for server
        {server,                         % Child ID
         {server, start_link, []},       % Module, function, and arguments to start the child
         permanent,                      % Child is supervised indefinitely
         5000,                           % Restart intensity: If the child fails 5 times within 5000 milliseconds, it won't be restarted
         worker,                         % Child type: worker process
         [server]}                       % Child's extra arguments
      ]}}.
