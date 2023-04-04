#include <stdio.h>

// Global variable with static storage duration and internal linkage
static int global_static = 10;

// Global variable with external linkage
int global = 20;

// from 5_constants.c
extern int MAX_VALUE;


int main() {
   // The auto storage class is the default storage class for all local variables.
   auto int a = 30;
   
   /*
   The register storage class is utilized to specify local variables that should be 
   held in a register rather than in RAM. As a result, the variable has a size limit 
   that corresponds to the register size, typically one word, and cannot be manipulated 
   with the unary '&' operator because it lacks a memory location. 
   This storage class is best suited for variables that need fast access, such as counters. 
   Additionally, it's important to note that using the 'register' 
   keyword does not guarantee that the variable will be stored in a register, 
   as this will depend on hardware and implementation restrictions.
   */
   register int b = 40;
   
   /*
   By using the static storage class, the compiler is instructed to keep a local variable 
   alive for the duration of the program rather than creating and destroying it each time 
   it enters and exits a scope. As a result, local variables can maintain their values 
   between function calls.

   The static modifier can also be applied to global variables, 
   restricting their scope to the file in which they are declared.

   When the static keyword is used on a global variable in C programming, 
   only one copy of that member is shared by all objects in its class.
   */
   static int c = 50;


   
   printf("Global variables:\n");
   printf("global_static = %d\n", global_static);
   printf("global = %d\n", global);
   
   printf("Local variables:\n");
   printf("a = %d\n", a);
   printf("b = %d\n", b);
   printf("c = %d\n", c);

   printf("external MAX_VALUE= %d\n",MAX_VALUE);
   
   return 0;
}
