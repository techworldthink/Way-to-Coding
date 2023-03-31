#include <stdio.h>

#define PI 3.14159            // integer constant
const int MAX_VALUE = 100;   // const integer constant

int main() {
   float const E = 2.71828;  // const floating-point constant
   char const CH = 'A';      // const character constant
   char const STR[] = "Hello, world!";  // const string constant
   
   printf("Integer constants:\n");
   printf("PI = %f\n", PI);
   printf("MAX_VALUE = %d\n", MAX_VALUE);
   
   printf("Floating-point constant:\n");
   printf("E = %f\n", E);
   
   printf("Character and string constants:\n");
   printf("CH = %c\n", CH);
   printf("STR = %s\n", STR);
   
   return 0;
}
