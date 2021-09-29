# List details of users with uid > 500

cat /etc/passwd | while read row
do
 let pos3=$(echo $row | cut -d ":" -f 3) 
 if [ $pos3 -gt 500 ]
 then
   echo $row | column -s ":" -t;
 fi
done
