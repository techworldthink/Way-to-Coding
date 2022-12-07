class static_example {
    static void method1(){
        System.out.println("static method");
    }
    public static void main(String []args){
        System.out.println("inside main");
        static_example.method1();
    }
    static{
        System.out.println("inside static block");
        static_example.method1();
    }
}
