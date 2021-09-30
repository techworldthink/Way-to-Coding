# Read a Folder name and File name from user as arguments
# If folder not present , create it
# If file present ,  remove it
# If file not present in the given directory , create it and add this content "CET_MCA"

# To check the number of argumnets
if [ $# -lt 2 ]; then
	echo "Atleast 2 arguments needed (Folder,File)";
	exit; 
fi

# To  check folder present or not
if [ -d $1 ]; then
	echo "Folder already present";
else
	echo "$1 Folder created";
	mkdir $1;
fi

# To check file exists or not
if [ -f $2 ]; then
	echo "$2 Deleted";
	rm $2;
else
	touch $2;
	echo "CET_MCA" > $2;
fi
