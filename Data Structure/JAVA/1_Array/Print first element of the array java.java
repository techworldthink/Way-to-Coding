class LinearTimeComplexity {

        public static int getFirst(int[] nums) {
                return nums[0];
        }

        public static void main(String[] args) {

                int[] numbers = new int[10000000];

                for (int i = 0; i < numbers.length; i++)
                        numbers[i] = i;

                long start = System.currentTimeMillis();
                getFirst(numbers);
                System.out.println("Time taken : " + (System.currentTimeMillis() - start));

        }
}