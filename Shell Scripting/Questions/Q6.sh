# read vaccination status from student
# if not vaccinated - not allow to write exams
# first dose onlt - need rtpcr
# two doses - allow 
# write the result to a file

# To check the number of argumnets
if [ $# -lt 1 ]; then
        echo "Atleast 1 arguments needed";
	echo "0 - Not vaccinated"
	echo "1 - First dose only"
	echo "2 - Two doses"
        exit; 
fi

if [ $1 -eq 0 ]; then
	echo "NOT ALLOWED" > status.txt;
elif [ $1 -eq 1 ]; then
	echo "Need to submit RTPCR " > status.txt;
elif [ $1 -eq 2 ]; then
	echo "Allow" > status.txt;
else
	echo "Invalid option";
fi

echo "give this command to show status : cat status.txt"
