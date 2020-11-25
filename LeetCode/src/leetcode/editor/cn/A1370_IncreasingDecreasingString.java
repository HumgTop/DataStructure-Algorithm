package leetcode.editor.cn;


public class A1370_IncreasingDecreasingString {
    public static void main(String[] args) {
        System.out.println(new A1370_IncreasingDecreasingString().new Solution().sortString(" "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    @SuppressWarnings("ConditionalBreakInInfiniteLoop")
    class Solution {
        public String sortString(String s) {
            int n = s.length();

            StringBuilder sb = new StringBuilder();
            int[] letterCnt = new int[26];
            //初始化字母计数器
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                letterCnt[ch - 'a'] += 1;
            }

            int cnt = 0;    //实时维护sb中添加的字母个数
            while (true) {
                int i = 0;
                while (cnt < n && i < 26) {
                    if (letterCnt[i] > 0) {
                        letterCnt[i]--;
                        sb.append((char) (i + 'a'));
                        cnt++;
                    }
                    i++;
                }
                while (cnt < n && i > 0) {
                    i--;
                    if (letterCnt[i] > 0) {
                        letterCnt[i]--;
                        sb.append((char) (i + 'a'));
                        cnt++;
                    }
                }

                if (cnt == n) break;
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}