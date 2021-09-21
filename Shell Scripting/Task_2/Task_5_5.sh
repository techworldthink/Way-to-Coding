#!/bin/bash

printf "\n1)Add 2)Substract 3)Multiple 4) Divide 0)Exit\nopt :: ";
read opt;

while [ $opt != '0' ]
do
	echo "First no : ";
	read a;
	echo "Second no : ";
	read b;

	case "$opt" in
				"1") echo "sum : $(($a + $b))";;
                "2") echo "sum : $(($a - $b))";;
                "3") echo "sum : $(($a * $b))";;
                "4") echo "sum : $(($a / $b))";;
	esac

	printf "\n1)Add 2)Substract 3)Multiple 4) Divide\nopt :: ";
	read opt;
done
