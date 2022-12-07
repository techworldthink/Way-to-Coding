class EvenOddThreads {

    int fromMin;
    int toMax;

    EvenOddThreads(int fromMin, int toMax) {
        this.fromMin = fromMin;
        this.toMax = toMax;
    }

    public void printOddNumber() {
        synchronized (this) {
            while (fromMin < toMax) {
                while (fromMin % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(fromMin + " ");
                fromMin++;
                notify();
            }
        }
    }

    public void printEvenNumber() {
        synchronized (this) {
            while (fromMin < toMax) {
                while (fromMin % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(fromMin + " ");
                fromMin++;
                notify();
            }
        }
    }

    public static void main(String[] args) {

        EvenOddThreads mt = new EvenOddThreads(50, 100);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                mt.printEvenNumber();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                mt.printOddNumber();
            }
        });

        t1.start();
        t2.start();
    }
}
