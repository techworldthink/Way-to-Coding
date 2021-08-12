#!/bin/sh

a=2
b=10

#............................................

if [ $a -gt $b ]
then
	echo "a>b"
else
	echo "b>a"
fi

#.............................................

if [ $a -lt $b ]
then
        echo "a<b"
else
        echo "b<a"
fi

#.............................................

if [ $a -ge $b ]
then
        echo "a>=b"
else
        echo "b>=b"
fi

#.............................................

if [ $a -le $b ]
then
        echo "a<=b"
else
        echo "b<=a"
fi

#.............................................

if [ $a -eq $b ]
then
        echo "a=b"
else
        echo "b!=b"
fi

#.............................................

if [ $a -ne $b ]
then
        echo "a!=b"
else
        echo "a==b"
fi

