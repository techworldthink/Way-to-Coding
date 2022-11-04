class LinearTimeComplexity {

        static int[] bubbleSort(int[] arr) {
                int n = arr.length;
                int temp = 0;
                for (int i = 0; i < n; i++) {
                        for (int j = 1; j < (n - i); j++) {
                                if (arr[j - 1] > arr[j]) {
                                        // swap elements
                                        temp = arr[j - 1];
                                        arr[j - 1] = arr[j];
                                        arr[j] = temp;
                                }

                        }
                }

                return arr;
        }

        static void printArray(int[] arr) {
                for (int i = 0; i < arr.length; i++)
                        System.out.print(arr[i] + "\t");
        }

        public static void main(String[] args) {

                int[] numbers = new int[10];

                for (int i = 0; i < numbers.length; i++)
                        numbers[i] = i;

                numbers[0] = 123;

                long start = System.currentTimeMillis();
                numbers = bubbleSort(numbers);
                System.out.println("Time taken : " + (System.currentTimeMillis() - start));
                printArray(numbers);

        }
}