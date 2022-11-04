class LinearSearch {

        static int[] numbers = new int[10000000];

        public static int search(int[] nums, int item) {
                for (int i = 0; i < nums.length; i++) {
                        if (nums[i] == item)
                                return nums[i];

                }
                return -1;
        }

        public static void main(String[] args) {

                for (int i = 0; i < numbers.length; i++)
                        numbers[i] = i;

                long start = System.currentTimeMillis();
                System.out.println("Find ? " + search(numbers, 342504));
                System.out.println("Time taken : " + (System.currentTimeMillis() - start));

        }
}