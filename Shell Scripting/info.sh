#!/bin/sh


# The process number of the current shell. For shell scripts, this is the process ID under which they are executing
echo "PID : $$"

echo "FileName : $0"

echo "Argument value at position 1 you given : $1"

echo "No of Arguments : $#"

echo "All the arguments are double quoted : $*"

echo "All the arguments are individually double quoted : $@"

echo "The exit status of the last command executed : $?"

echo "The process number of the last background command : $!"

