package leetcode.editor.cn;


import java.util.*;

public class A49_GroupAnagrams {
    public static void main(String[] args) {

        Solution solution = new A49_GroupAnagrams().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            TreeMap<Character, Integer> letterCnt = new TreeMap<>();    //单个单词中的出现字母计数器

            HashMap<String, List<String>> map = new HashMap<>();    //存放字母异位词

            for (String word : strs) {
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    letterCnt.put(ch, letterCnt.getOrDefault(ch, 0) + 1);   //计数器对应的字母+1
                }
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<Character, Integer> entry : letterCnt.entrySet()) {
                    //将key添加value次
                    for (Integer i = 0; i < entry.getValue(); i++) {
                        sb.append(entry.getKey());
                    }
                }
                map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(word);   //将字母异位词添加到同一个key对应的集合中
                letterCnt.clear();
            }

            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}