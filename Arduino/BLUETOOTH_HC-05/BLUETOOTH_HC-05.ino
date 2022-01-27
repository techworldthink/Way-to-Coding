#include <SoftwareSerial.h>

SoftwareSerial BT(10, 11); //Rx, Tx respectively
String readdata;

void setup() 
{
  BT.begin(9600);
  Serial.begin(9600);
 // pinMode(13, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7,OUTPUT);
  
}

void loop() 
{
  while (BT.available())      //Check if there is an available byte to read
  {  
  delay(10);                  //Delay added to make thing stable
  char c = BT.read();         //Conduct a serial read
  readdata += c;              //build the string- "forward", "reverse", "left" and "right"
  } 
  if (readdata.length() > 0) 
  {
    Serial.println(readdata);
    if(readdata == "F" || readdata == "f")
  {
    digitalWrite(13, HIGH);
    digitalWrite(3, LOW);
    digitalWrite(4, HIGH);
    digitalWrite(5, HIGH);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    
    delay(100);
  }

  else if(readdata == "B" || readdata == "b")
  {
    digitalWrite(13, LOW);
    digitalWrite(3, HIGH);
    digitalWrite(4, LOW);
    digitalWrite(5, HIGH);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    delay(100);
  }

  else if (readdata == "L" || readdata == "l")
  {
    digitalWrite(13, HIGH);
    digitalWrite(3, HIGH);
    digitalWrite(4, HIGH);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    delay(100);
  }

 else if ( readdata == "R" || readdata == "r")
 {
   digitalWrite(13, HIGH);
    digitalWrite(3, HIGH);
    digitalWrite(4, HIGH);
    digitalWrite(5, HIGH);
    digitalWrite(6, HIGH);
    digitalWrite(7, LOW);
    delay(100);
  }

 else if (readdata == "S" || readdata == "s")
 {
    digitalWrite(13, LOW);
    digitalWrite(3, LOW);
    digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, HIGH);
    digitalWrite(7, LOW);
    delay(100);
  }
readdata="";        //Reset the variable
}
} 
