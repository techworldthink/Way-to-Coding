#include<iostream>

void my_function(int *data){
    // change value of data variable 
    *data = 8;
}

int main(){
    int data = 12;
    std::cout<<data;
    // passes a pointer of variable - data
    my_function(&data);
    // The value of the data variable changed by my_function.
    std::cout<<data;
}