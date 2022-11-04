
class IntegerReversion {

        public static int reverseInterger(int number) {
                int reversed = 0;
                int remainder = 0;
                while (number > 0) {
                        remainder = number % 10;
                        number /= 10;
                        reversed = reversed * 10 + remainder;
                }
                return reversed;

        }

        public static void main(String[] args) {
                System.out.println("Reverse 1234 :: "+reverseInterger(1234));
        }
}