#!/bin/bash

g++ -c $1 -o out;
g++ out;
./a.out;
echo "";
echo "....Compleated...."
