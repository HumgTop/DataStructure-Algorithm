package leetcode.editor.cn;

public class A485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new A485_MaxConsecutiveOnes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int pre = 0;
            int cnt = 0;
            int res = 0;
            for (int num : nums) {
                if (pre == 0) {
                    if (num == 1) {
                        cnt = 1;
                        pre = 1;
                        res = Math.max(res, cnt);
                    }

                } else {
                    if (num == 1) cnt++;
                    else {
                        res = Math.max(res, cnt);
                        pre = 0;
                    }
                }
            }

            return Math.max(res, cnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}