#!/bin/sh

let a=0

while [ "$a" -lt 10 ]
do
	echo $a
	let a=$a+1
done
