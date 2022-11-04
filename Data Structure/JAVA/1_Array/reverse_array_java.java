class ReverseArray {

        public static int[] reverseArray(int[] nums) {
                int lowIndex = 0;
                int highIndex = nums.length - 1;

                while (lowIndex < highIndex) {
                        swap(nums, lowIndex, highIndex);
                        lowIndex++;
                        highIndex--;
                }
                return nums;
        }

        private static void swap(int[] nums, int lowIndex, int highIndex) {
                int temp = nums[lowIndex];
                nums[lowIndex] = nums[highIndex];
                nums[highIndex] = temp;
        }

        public static void main(String[] args) {

                int[] data = new int[10];
                // initialize array
                for (int i = 0; i < data.length; i++)
                        data[i] = i;

                System.out.print("\nBefore reversing\n");
                for (int i = 0; i < data.length; i++)
                        System.out.print(data[i] + "\t");

                // reverse O(N)
                data = reverseArray(data);

                System.out.print("\nAfter reversing\n");
                for (int i = 0; i < data.length; i++)
                        System.out.print(data[i] + "\t");

        }
}