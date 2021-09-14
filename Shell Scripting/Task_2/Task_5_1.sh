printf "\n directory / file path  : ";
read PASSED;

if [[ -d $PASSED ]]; then
    echo "$PASSED is a directory"
elif [[ -f $PASSED ]]; then
    echo "$PASSED is a file"
else
    echo "$PASSED is not valid"
    exit 1
fi

