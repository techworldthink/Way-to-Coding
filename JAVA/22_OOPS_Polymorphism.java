class Main{
    public static void main(String[] args){
        A obj_A = new A();
        B obj_B = new B();
        C obj_C = new C();

        obj_A.dis();
        obj_B.dis();
        obj_C.dis();
    }
}


class A {
    void dis() {
        System.out.println("A");
    }
}

class B extends A {
    void dis() {
        System.out.println("B");
    }
}

class C extends B {
    void dis() {
        System.out.println("C");
    }
}