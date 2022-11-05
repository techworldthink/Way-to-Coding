import java.util.Arrays;

class DutchFlagProblem {

        private int[] nums;

        public DutchFlagProblem(int[] nums) {
                this.nums = nums;
        }

        private void swap(int index_1, int index_2) {
                int temp = nums[index_1];
                nums[index_1] = nums[index_2];
                nums[index_2] = temp;
        }

        public void solve() {
                int i = 0;
                int j = 0;
                int k = nums.length - 1;
                // middle value (0,1,2)
                int pivot = 1;

                while (j <= k) {
                        if (nums[j] < pivot) {
                                swap(i, j);
                                i++;
                                j++;
                        } else if (nums[j] > pivot) {
                                swap(j, k);
                                k--;
                        } else {
                                j++;
                        }

                }
        }

        public void showResult() {
                System.out.println(Arrays.toString(nums));
        }

        public static void main(String[] args) {
                int[] nums = { 1, 2, 2, 0, 1, 0 };
                DutchFlagProblem obj = new DutchFlagProblem(nums);
                obj.solve();
                obj.showResult();
        }
}