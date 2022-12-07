import java.util.Random;

class EvenPrint extends Thread {

    int max;

    EvenPrint(int max) {
        this.max = max;
    }

    public void run() {
        for (int i = 1; i < this.max; i++) {
            if (i % 2 == 0) {
                System.out.println("Even :  " + i);
            }
        }

    }

}

class OddPrint extends Thread {

    int max;

    OddPrint(int max) {
        this.max = max;
    }

    public void run() {
        for (int i = 1; i < this.max; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd :  " + i);
            }
        }
    }

}

class RandomNumber extends Thread {

    int min;
    int max;
    int times;

    RandomNumber(int min, int max, int times) {
        this.min = min;
        this.max = max;
        this.times = times;
    }

    public void run() {

        Random random = new Random();

        for (int i = 0; i < this.times; i++) {

            int randomInteger = random.nextInt(this.min, this.max);

            System.out.println("Random Integer generated : " + randomInteger);

            if (randomInteger % 2 == 0) {
                EvenPrint s = new EvenPrint(randomInteger);
                s.start();
            } else {
                OddPrint c = new OddPrint(randomInteger);
                c.start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        }

    }

}

class Main {

    public static void main(String args[]) {

        RandomNumber obj = new RandomNumber(1, 10, 2);

        obj.start();

    }

}