
class TrappedRainProblem {

        private int[] heights;

        public TrappedRainProblem(int[] heights) {
                this.heights = heights;
        }

        // It has O(N) running time (with additional O(N) memory complexity)
        // Dynamic programming approach - memorization
        public int solve() {

                // less than 3 bars can not trap any water
                if (heights.length < 3)
                        return 0;

                // create arrays for the max left and right values
                int[] leftMax = new int[heights.length];
                int[] rightMax = new int[heights.length];

                // calculating the left max values (from left to right)
                leftMax[0] = 0;
                for (int i = 1; i < leftMax.length; i++)
                        leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);

                // calculating the right max values (from right to left)
                rightMax[rightMax.length - 1] = 0;
                for (int i = rightMax.length - 2; i >= 0; i--)
                        rightMax[i] = Math.max(rightMax[i + 1], heights[i + 1]);

                // consider all the items in O(N) running time
                int trapped = 0;

                for (int i = 1; i < heights.length - 1; i++)
                        if (Math.min(leftMax[i], rightMax[i]) > heights[i])
                                trapped += Math.min(leftMax[i], rightMax[i]) - heights[i];
                return trapped;
        }

        public static void main(String[] args) {
                int[] heights = { 2, 0, 3 };
                TrappedRainProblem obj = new TrappedRainProblem(heights);
                System.out.println(obj.solve());
        }
}