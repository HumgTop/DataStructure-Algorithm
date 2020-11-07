package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class A_49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new A_49GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> res = new HashMap<>();
            int[] count = new int[26];
            for (String str : strs) {
                Arrays.fill(count, 0);
                for (char ch : str.toCharArray()) {
                    count[ch - 'a']++;
                }
                //将count数组用字符串表示
                StringBuilder sb = new StringBuilder();
                for (int i : count) {
                    sb.append('#');
                    sb.append(i);
                }
                String key = sb.toString();
                if (!res.containsKey(key)) res.put(key, new ArrayList<>());
                res.get(key).add(str);
            }

            return new ArrayList<>(res.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}