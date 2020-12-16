package leetcode.editor.cn;


public class A738_MonotoneIncreasingDigits {
    public static void main(String[] args) {

        Solution solution = new A738_MonotoneIncreasingDigits().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            char[] strN = Integer.toString(N).toCharArray();
            int i = 1;
            while (i < strN.length && strN[i - 1] <= strN[i]) {
                i += 1;
            }
            if (i < strN.length) {
                while (i > 0 && strN[i - 1] > strN[i]) {
                    strN[i - 1] -= 1;
                    i -= 1;
                }
                for (i += 1; i < strN.length; ++i) {
                    strN[i] = '9';
                }
            }
            return Integer.parseInt(new String(strN));
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}