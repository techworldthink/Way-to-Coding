#!/bin/bash

echo "User : $(whoami)";
echo "Current shell : $(readlink /proc/$$/exe)";
echo "Home Directory";
ls "/home/$(whoami)/";
echo "OS : $(uname)";
echo "Current directory : $(pwd)";


#ps -p $$ -o comm=;
#readlink /proc/$$/exe;

