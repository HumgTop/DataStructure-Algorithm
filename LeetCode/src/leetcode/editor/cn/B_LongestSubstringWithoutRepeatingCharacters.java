package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;


public class B_LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aabaab!bb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.equals("")) return 0;
            char[] chs = s.toCharArray();

            int res = 1;


            Deque<Character> deque = new LinkedList<>();
            for (char ch : chs) {
                //如果入列字符后出现重复，记录此时队列长度。循环出列直到移除重复字符
                if (deque.contains(ch)) {
                    res = Math.max(res, deque.size());
                    while (!deque.isEmpty()) {
                        if (deque.removeFirst() == ch) break;
                    }
                }
                deque.addLast(ch);
            }

            return Math.max(res, deque.size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}