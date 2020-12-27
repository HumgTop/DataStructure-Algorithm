package leetcode.editor.cn;


import java.util.HashMap;
import java.util.HashSet;

public class A205_IsomorphicStrings {
    public static void main(String[] args) {

        Solution solution = new A205_IsomorphicStrings().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;

            HashMap<Character, Character> map = new HashMap<>();    //确保每个value只被映射一次
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!map.containsKey(ch)) {
                    if (set.contains(t.charAt(i))) return false;    //value已经被映射过一次

                    map.put(ch, t.charAt(i));
                    set.add(t.charAt(i));
                } else if (map.get(ch) != t.charAt(i)) return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}