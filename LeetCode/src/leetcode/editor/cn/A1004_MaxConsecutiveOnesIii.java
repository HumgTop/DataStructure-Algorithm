package leetcode.editor.cn;

public class A1004_MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new A1004_MaxConsecutiveOnesIii().new Solution();
        int[] input = LeetCodeUtils.get1dArr("[0,0,1,1,1,0,0]");
        System.out.println(solution.longestOnes(input, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] A, int K) {
            int left = 0, right = 0;
            //滑动窗口：保证窗口内只有k个0
            //窗口内0不满k时，right++
            //窗口内0的个数==k时，left++，直到0的个数==k-1，right继续++
            int curK = 0;
            int res = 0;

            while (right < A.length) {
                if (A[right] == 0) curK++;
                //当窗口内0的个数超过k时，移动left
                while (curK > K) {
                    if (A[left] == 0) {
                        curK--;
                    }
                    left++;
                }
                res = Math.max(res, right - left + 1);

                right++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}