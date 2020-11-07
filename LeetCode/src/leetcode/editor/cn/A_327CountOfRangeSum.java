package leetcode.editor.cn;

public class A_327CountOfRangeSum {
    public static void main(String[] args) {
        Solution solution = new A_327CountOfRangeSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int res = 0;
            //子区间起始位置
            for (int i = 0; i < nums.length; i++) {
                //子区间结束的位置
                for (int j = i; j < nums.length; j++) {
                    long temp = 0;
                    //对子区间求和
                    for (int k = i; k <= j; k++) {
                        temp += nums[k];
                    }
                    //如果和合法，结果加一
                    if (lower <= temp && temp <= upper) res++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}