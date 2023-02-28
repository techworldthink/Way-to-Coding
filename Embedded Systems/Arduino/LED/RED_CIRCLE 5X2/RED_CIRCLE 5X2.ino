#define LOOP 2

void setup() {
pinMode(2,OUTPUT);
pinMode(3,OUTPUT);
pinMode(4,OUTPUT);
pinMode(5,OUTPUT);
pinMode(6,OUTPUT);

//Ground
pinMode(7,OUTPUT);
pinMode(8,OUTPUT);
}

void loop() 
{
  loop_();

}

void loop_(){
  int i;
  for(i=1;i<=LOOP;i++){
  //one
  digitalWrite(7,LOW);
  digitalWrite(8,HIGH);

  digitalWrite(2,LOW);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
  delay_sm();
  digitalWrite(7,HIGH);
  digitalWrite(8,LOW);

  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,LOW);
  delay_sm();
  }
  
  for(i=1;i<=LOOP;i++){
   //one
  digitalWrite(7,LOW);
  digitalWrite(8,HIGH);

  digitalWrite(2,HIGH);
  digitalWrite(3,LOW);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
  delay_sm();
  digitalWrite(7,HIGH);
  digitalWrite(8,LOW);

  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,LOW);
  digitalWrite(6,HIGH);
    delay_sm();
  }
  
  for(i=1;i<=LOOP;i++){
  //one
  digitalWrite(7,LOW);
  digitalWrite(8,HIGH);

  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,LOW);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
  delay_sm();
  digitalWrite(7,HIGH);
  digitalWrite(8,LOW);

  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,LOW);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
    delay_sm();
  }

  for(i=1;i<=LOOP;i++){
  //one
  digitalWrite(7,LOW);
  digitalWrite(8,HIGH);

  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,LOW);
  digitalWrite(6,HIGH);
  delay_sm();
  digitalWrite(7,HIGH);
  digitalWrite(8,LOW);

  digitalWrite(2,HIGH);
  digitalWrite(3,LOW);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
    delay_sm();
  }
  
  for(i=1;i<=LOOP;i++){
  //one
  digitalWrite(7,LOW);
  digitalWrite(8,HIGH);

  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,LOW);
  delay_sm();
  digitalWrite(7,HIGH);
  digitalWrite(8,LOW);

  digitalWrite(2,LOW);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(6,HIGH);
    delay_sm();
  }

}

void delay_(){
 delay(200);
}
void delay_sm(){
  delay(10);
}
