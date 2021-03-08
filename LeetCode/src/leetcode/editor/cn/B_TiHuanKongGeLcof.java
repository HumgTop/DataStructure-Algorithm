package leetcode.editor.cn;


public class B_TiHuanKongGeLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur != ' ') sb.append(cur);
                else sb.append("%20");
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}