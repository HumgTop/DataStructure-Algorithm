package leetcode.editor.cn;


public class B_MinimumFlipsToMakeAOrBEqualToC {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int a, int b, int c) {
            int res = 0;  //翻转次数
            //枚举30位（从低向高位枚举）
            for (int i = 0; i < 30; i++) {
                int bitC = (c >> i) & 1;
                int bitA = (a >> i) & 1;
                int bitB = (b >> i) & 1;
                if (bitC == 0) {
                    res += (bitA + bitB);
                } else {
                    if (bitA == 0 && bitB == 0) {
                        res += 1;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}