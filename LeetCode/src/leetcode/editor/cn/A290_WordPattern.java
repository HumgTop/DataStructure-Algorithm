package leetcode.editor.cn;


import java.util.HashMap;
import java.util.HashSet;

public class A290_WordPattern {
    public static void main(String[] args) {

        Solution solution = new A290_WordPattern().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if (words.length != pattern.length()) return false;

            char[] chars = pattern.toCharArray();

            HashSet<String> existedWords = new HashSet<>(); //已经存在的单词
            HashMap<Character, String> dict = new HashMap<>();  //key为pattern中的字符，value为其对应的word

            for (int i = 0; i < chars.length; i++) {
                if (!dict.containsKey(chars[i])) {
                    if (existedWords.contains(words[i])) return false;
                    dict.put(chars[i], words[i]);
                    existedWords.add(words[i]);
                }
                //如果该模式串字符已在字典中，校验当前word是否匹配
                if (!words[i].equals(dict.get(chars[i]))) return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}