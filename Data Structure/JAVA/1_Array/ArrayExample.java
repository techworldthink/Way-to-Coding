public class ArrayExample {
    public static void main(String[] args) {
        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}