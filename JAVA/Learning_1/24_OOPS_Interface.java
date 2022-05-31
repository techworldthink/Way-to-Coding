class Main {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
    }
}

interface A {
    int ID = 12;
    public void show();
}

class B implements A {
    public void show() {
        System.out.println("A show");
    }
}
