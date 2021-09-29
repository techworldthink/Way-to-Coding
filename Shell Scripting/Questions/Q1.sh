let con=1;

while [ $con -ne 0 ]
do
 echo "1) user details"
 echo "2) current user"
 echo "3) present working directory"
 echo "4) Exit"
 echo "Choice :: "
 read con
 case $con in
   1) cat /etc/passwd | column -s ":" -t;;
   2) whoami;;
   3) pwd;;
   4) exit;;
 esac
done
