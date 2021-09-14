#!/bin/bash

echo "First file ; ";
read file1;
echo "Second file : ";
read file2;


if(diff $file1 $file2) 
then 
	echo "Same"; 
else 
	echo "Different"; 
fi

