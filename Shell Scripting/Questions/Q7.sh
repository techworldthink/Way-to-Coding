# read filename and username from user as arguments
# check arguments count is correct , if not print a  error message
# check file exists, if not create it
# check username present in that given file , if not add the name to last of the file

# To check the number of argumnets
if [ $# -lt 2 ]; then
        echo "Atleast 2 arguments needed (Filename,Username)";
        exit; 
fi

if [ -f $1 ];then
	echo "$1 present";
else
	echo "$1 not present , so created";
	touch $1;
fi

let flag=$(cat $1 | grep $2 | wc -w )

if [ $flag -gt 0 ];then
	echo "$2 user already present";
else
	echo "$2" >> $1;
fi

