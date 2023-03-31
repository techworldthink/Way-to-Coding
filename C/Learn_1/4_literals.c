#include <stdio.h>

int main() {
   int a = 10;            // decimal integer literal
   int b = 012;           // octal integer literal (equals decimal 10)
   int c = 0xA;           // hexadecimal integer literal (equals decimal 10)
   float d = 3.14;        // decimal floating-point literal
   float e = 6.02e23;     // scientific notation floating-point literal
   char f = 'A';          // character literal
   char g[] = "Hello";    // string literal
   
   printf("Integer literals:\n");
   printf("a = %d\n", a);
   printf("b = %d\n", b);
   printf("c = %d\n", c);
   
   printf("Floating-point literals:\n");
   printf("d = %f\n", d);
   printf("e = %e\n", e);
   
   printf("Character and string literals:\n");
   printf("f = %c\n", f);
   printf("g = %s\n", g);
   
   return 0;
}
