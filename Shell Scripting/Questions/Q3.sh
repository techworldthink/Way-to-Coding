echo "uid : "
read uuid
cat /etc/passwd | while read row
do
 let uid=$(echo $row | cut -d ":" -f 3)
 if [ $uid -eq $uuid ]
 then 
   printf "\n\n-------- name , home directory , shell , group ----------\n\n";
   echo $row | cut -d ":" -f 1,6,7,4
   let ggid=$(echo $row | cut -d ":" -f 4)
   let usr=$(echo $row | cut -d ":" -f 2)
   printf "\n\n---------Groups belongs to that user--------------\n\n";
   echo $( groups $(echo $row  | cut -d ":" -f 1));
   cat /etc/group | while read row2
   do
    let gid=$(echo $row2 | cut -d ":" -f 3)
    if [ $gid -eq $ggid ]
    then
      printf "\n\n----------group name------------\n\n"
      echo $row2 | cut -d ":" -f 1
    fi
   done
 fi
done
