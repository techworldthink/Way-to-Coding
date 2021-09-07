class B extends A{
    public static void main(String[] args){
        B obj = new B();
        obj.display_ID();
        System.out.println(obj.ID2);
    }
}

class A {
    private int ID = 12;
    protected int ID2 = 13;

    void display_ID(){
        System.out.println(ID);
    }
}

