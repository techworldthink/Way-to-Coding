#include <stdio.h>

int main()
{
    /* 1. Integer types */
    /*
    a signed char uses one bit to represent the sign (positive or negative) of the value,
    while an unsigned char uses all eight bits to represent the value.
    */
    // 1 byte : -128 to 127 or 0 to 255
    char c = 'A';
    // can store values (0 - 255)
    unsigned char c_ = 255;
    // signed char can store negative values (-128 to 127)
    signed char c__ = 127;
    // 2 bytes : -32,768 to 32,767
    short s = 10;
    // 2 or 4 bytes : -32,768 to 32,767 or -2,147,483,648 to 2,147,483,647
    int i = 123;
    // 8 bytes or (4bytes for 32 bit OS) : -9223372036854775808 to 9223372036854775807
    long l = 123456;
    // 8 bytes
    long long ll = 123456789;

    // Floating-point types
    // 4 bytes
    float f = 3.14159f;
    // 8 bytes
    double d = 3.14159265358979323846;
    // 10 bytes
    long double ld = 3.14159265358979323846L;

    // Boolean type
    _Bool b = 1;

    // Output values
    printf("Char: %c\n", c);
    printf("Unsigned Char: %c\n", c_);
    printf("Signed Char: %c\n", c__);
    printf("Short: %hd\n", s);
    printf("Int: %d\n", i);
    printf("Long: %ld\n", l);
    printf("Long Long: %lld\n", ll);
    printf("Float: %f\n", f);
    printf("Double: %lf\n", d);
    printf("long double: %Lf\n", ld);
    printf("Boolean: %d\n", b);

    return 0;
}
