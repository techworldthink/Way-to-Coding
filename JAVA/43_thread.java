class Main {
    public static void main(String[] args) {
        Main11 thread = new Main11();
        thread.start();
        System.out.println("This code is outside of the thread");

        Main12 obj = new Main12();
        Thread thread2 = new Thread(obj);
        thread2.start();
        System.out.println("This code is outside of the thread");
    }
}

// Method 1
class Main11 extends Thread {
    public void run() {
        System.out.println("This code is running in a thread");
    }
}

// Method 2
class Main12 implements Runnable {
    public void run() {
        System.out.println("This code is running in a thread");
    }
}