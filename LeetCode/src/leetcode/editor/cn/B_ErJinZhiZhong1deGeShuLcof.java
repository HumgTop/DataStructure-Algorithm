package leetcode.editor.cn;


public class B_ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            String s = Integer.toBinaryString(n);
            int cnt = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') cnt++;
            }

            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}