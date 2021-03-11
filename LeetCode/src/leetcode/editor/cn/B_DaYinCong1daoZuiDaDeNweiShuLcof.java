package leetcode.editor.cn;


public class B_DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int maxNum = (int) Math.pow(10, n) - 1;
            int[] res = new int[maxNum];
            for (int i = 0; i < maxNum; i++) {
                res[i] = i + 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}