package leetcode.editor.cn;

public class A566_ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution solution = new A566_ReshapeTheMatrix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length;
            int n = nums[0].length;
            if (m * n != r * c) return nums;

            int[][] res = new int[r][c];
            int curR = 0;
            int curC = 0;

            for (int[] num : nums) {
                for (int val : num) {
                    res[curR][curC++] = val;
                    if (curC == c) {
                        curR++;
                        curC = 0;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}