package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;


public class B_MinimumWindowSubstring {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ab", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //根据t建立hashmap，key为字符，value为当前窗口关于此字符的缺少个数
            HashMap<Character, Integer> need = new HashMap<>();
            int minLen = Integer.MAX_VALUE;
            int resLeft = 0;
            int resRight = 0;

            //窗口中仍需要的必要元素数量
            int needCnt = t.length();
            //初始化need
            for (int i = 0; i < needCnt; i++) {
                char ch = t.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }

            int left = 0, right = 0;
            while (right < s.length()) {
                //刷新need
                char ch = s.charAt(right);
                if (need.containsKey(ch)) {
                    if (need.get(ch) > 0) {
                        //如果是必要元素，needCnt--
                        needCnt--;
                    }
                    need.put(ch, need.get(ch) - 1);
                }
                //此时窗口包括所有必要元素，移动左边界
                while (needCnt == 0) {
                    char leftCh = s.charAt(left);
                    if (need.containsKey(leftCh)) {
                        if (need.get(leftCh) == 0) {
                            //记录可能的最短覆盖子串
                            if (right - left + 1 < minLen) {
                                minLen = right - left + 1;
                                resLeft = left;
                                resRight = right;
                            }
                            break;
                        }
                        need.put(leftCh, need.get(leftCh) + 1);
                    }
                    left++;
                }
                right++;
            }

            if (needCnt > 0) return "";

            return s.substring(resLeft, resRight + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}