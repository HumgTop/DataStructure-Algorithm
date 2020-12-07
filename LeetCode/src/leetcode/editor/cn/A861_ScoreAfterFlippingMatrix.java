package leetcode.editor.cn;


public class A861_ScoreAfterFlippingMatrix {
    public static void main(String[] args) {

        Solution solution = new A861_ScoreAfterFlippingMatrix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] A) {
            int m = A.length;
            int n = A[0].length;

            int res = 0;

            for (int[] nums : A) {
                if (nums[0] == 1) continue;
                //每行首位元素不为1的翻转该行
                for (int i = 0; i < n; i++) {
                    nums[i] = nums[i] == 1 ? 0 : 1;
                }
            }

            res += m * (1 << (n - 1));

            //遍历列进行翻转
            for (int i = 1; i < n; i++) {
                int cnt = 0;    //记录该列1的个数
                for (int[] row : A) {
                    if (row[i] == 1) cnt++;
                }
                cnt = Math.max(cnt, m - cnt);
                res += cnt * (1 << (n - i - 1));
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}