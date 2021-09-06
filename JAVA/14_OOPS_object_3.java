class Myclass1 {

    public static void main(String[] args) {
        Myclass myObj1 = new Myclass();
        Myclass myObj2 = new Myclass();
        myObj1.a = 12;
        myObj1.b=13;
        myObj2.a=14;
        myObj2.b=15;
        System.out.println(myObj1.a);
        System.out.println(myObj1.b);
        System.out.println(myObj2.a);
        System.out.println(myObj2.b);
        System.out.println(myObj2.x);
        System.out.println(myObj2.x);
    }
}

class  Myclass{
    int a=1;
    static int b=1;
    final int x = 10;
}