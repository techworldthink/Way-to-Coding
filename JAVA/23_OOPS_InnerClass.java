class Main {
    public static void main(String[] args) {
        A obj_A = new A();
        A.B obj_B = obj_A.new B();
        A.C obj_C = new A.C();

        obj_A.dis();
        obj_B.dis();
        obj_C.dis();
    }
}

class A {
    void dis() {
        System.out.println("A");
    }

    class B {
        void dis() {
            System.out.println("B");
        }
    }

    static class C {
        void dis() {
            System.out.println("C");
        }
    }
}
