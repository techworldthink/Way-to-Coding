class Main {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
        obj.disp();
    }
}

interface A1 {
    int ID = 12;

    public void disp();
}

interface A2 {
    int ID = 12;

    public void show();
}

class B implements A1, A2 {
    public void show() {
        System.out.println("A1");
    }

    public void disp() {
        System.out.println("A2");
    }
}
