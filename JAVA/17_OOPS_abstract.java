class Main3{
    public static void main(String[] args){
        T1 obj = new T1();
        obj.myfunc();
    }
}

abstract class myclass{
    public int ID = 109;
    public abstract void myfunc();
}

class T1 extends myclass{
    public void myfunc(){
        System.out.println("abstract method");
    }
}
