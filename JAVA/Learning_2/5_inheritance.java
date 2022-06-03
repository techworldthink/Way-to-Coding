class mainClass{
    public static void main(String []args){
        parentClass obj = new childClass();
        obj.message();
        childClass obj2 = new childClass();
        obj2.message();
        parentClass obj3 = new parentClass();
        obj3.message();
        // Error - ()
        // childClass obj4 = new parentClass();
    }
}

class parentClass{
    void message(){
        System.out.println("msge from parent");
    }
}

class childClass extends parentClass {
    @Override
    void message(){
        System.out.println("msge from child");
    }
}

