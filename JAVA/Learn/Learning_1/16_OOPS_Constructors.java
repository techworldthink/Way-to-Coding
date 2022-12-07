class Main{
    public static void main(String[] args){
        T obj = new T(123);
        System.out.println(obj.value());
    }
}

class T {
    int num;

    T(int num){
        this.num = num;
    }
    int value(){
        return num;
    }
}
