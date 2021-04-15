package leetcode.editor.cn;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class B_DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char ch : chars) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) return entry.getKey();
            }

            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}