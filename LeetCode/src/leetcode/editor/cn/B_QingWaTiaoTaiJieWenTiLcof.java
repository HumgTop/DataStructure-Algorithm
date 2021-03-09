package leetcode.editor.cn;


public class B_QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            if (n == 0 || n == 1) return 1;
            int num = 1000000007;
            int dp1 = 1;
            int dp2 = 1;
            int res = -1;
            for (int i = 0; i < n - 1; i++) {
                res = (dp1 + dp2) % num;
                dp1 = dp2;
                dp2 = res;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}