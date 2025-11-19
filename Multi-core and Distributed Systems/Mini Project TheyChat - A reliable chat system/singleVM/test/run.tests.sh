#!/bin/bash

# Path to the project src and test files directories
erlc -I ../src -I ../tests ../tests/*.erl

# Run the tests
erl -noshell -pa ../src -pa ../tests -eval "eunit:test([heychat_test]), init:stop()."
