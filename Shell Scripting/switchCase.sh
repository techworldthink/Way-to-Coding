CARS="bmw"
  
#Pass the variable in string
case "$CARS" in
    #case 1
    "mercedes") echo "Headquarters - Affalterbach, Germany" ;;
      
    #case 2
    "audi") echo "Headquarters - Ingolstadt, Germany" ;;
      
    #case 3
    "bmw") echo "Headquarters - Chennai, Tamil Nadu, India" ;;
esac
