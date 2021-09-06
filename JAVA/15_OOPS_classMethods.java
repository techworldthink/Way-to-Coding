class Main{
    public static void main(String[] args){
        T obj = new T();
        System.out.println(obj.sum(1,2));
    }
}

class T {
    int sum(int a,int b){
        return a+b;
    }
}
