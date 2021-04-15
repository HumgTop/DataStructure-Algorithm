package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class B_ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new B_ZiFuChuanDePaiLieLcof().new Solution();
        for (String s : solution.permutation("aab")) {
            System.out.println(s);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> resList;

        public String[] permutation(String s) {
            resList = new ArrayList<>();
            dfs(s.toCharArray(), new StringBuilder());
            return resList.toArray(new String[0]);
        }

        void dfs(char[] chars, StringBuilder sb) {
            if (sb.length() == chars.length) {
                resList.add(new String(sb));
                return;
            }

            HashSet<Character> used = new HashSet<>();  //标记本层已经使用的元素，已经使用过的元素不再使用
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ' && !used.contains(chars[i])) {
                    used.add(chars[i]);
                    sb.append(chars[i]);
                    char temp = chars[i];
                    chars[i] = ' '; //在本次递归栈中，标记已访问
                    dfs(chars, sb);
                    chars[i] = temp;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}