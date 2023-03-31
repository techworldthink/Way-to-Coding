/*
Explicit typecasting is required when we want to convert data from 
one type to another type that is not automatically convertible. 
It is important to note that explicit typecasting can result in loss of data or 
precision, and should be used with caution.
*/
#include <stdio.h>

int main() {
  int a = 10;
  float b = a; // implicit typecasting

  printf("Implicit Typecasting: int to float\n");
  printf("a = %d\n", a);
  printf("b = %f\n\n", b);

  float c = 10.5;
  int d = (int)c; // explicit typecasting

  printf("Explicit Typecasting: float to int\n");
  printf("c = %f\n", c);
  printf("d = %d\n\n", d);

  int e = 97;
  char ch = (char)e; // integer to char typecasting

  printf("Integer to Char Typecasting:\n");
  printf("e = %d\n", e);
  printf("ch = %c\n\n", ch);

  char ch2 = 'A';
  int f = (int)ch2; // char to integer typecasting

  printf("Char to Integer Typecasting:\n");
  printf("ch2 = %c\n", ch2);
  printf("f = %d\n\n", f);

  return 0;
}
