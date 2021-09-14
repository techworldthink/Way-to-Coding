#!/bin/bash

# To create file
printf "\nFile content : \n";
cat > myFile;

printf "\nprint data on myFile use tabs to seperate\n";
cat myFile | column -t -s ' ';

printf "\nSwap 2,3 fields of myFile\n";
cut -d " " -f 1,3 myFile  > cat  && cut -d " " -f 2 myFile | paste cat -;

printf "\nprint first 2 row only\n";
head -n  2  myFile;

printf "\nPrint last row\n";
head -n 3 myFile | tail -n 1;

printf "\nPrint only names\n";
cut -d " " -f 2 myFile;

printf "\nPrint word count,  lines count , letter count  \n";
cut -d " " -f 2  myFile | wc;

