/* static means that the method belongs to the Main class and 
    not an object of the Main class. You will learn more about objects and
     how to access methods through objects later in this tutorial
*/
class methods {
    static void myMethod() {
        System.out.println("I just got executed!");
    }
    static void myMethod(int no) {
        System.out.println(no);
    }
    static int myMethod2(int no) {
        System.out.println(no);
        return no*2;
    }
    public static int sum(int k) {
        if (k > 0) {
          return k + sum(k - 1);
        } else {
          return 0;
        }
      }
    public static void main(String[] args) {
        myMethod();
        myMethod(2);
        System.out.println(myMethod2(2));
        System.out.println(sum(4));
    }
}
