package leetcode.editor.cn;

import java.util.*;

public class A_438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new A_438FindAllAnagramsInAString().new Solution();
        // TO TEST
        for (Integer anagram : solution.findAnagrams("cbaebabacd", "abc")) {
            System.out.println(anagram);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Deque<Character> window = new LinkedList<>();
            int[] pCnt = new int[26];   //p的字母（出现次数）计数器
            int[] windowCnt = new int[26];  //window的字母计数器

            //初始化pCnt
            for (int i = 0; i < p.length(); i++) {
                pCnt[p.charAt(i) - 'a'] += 1;
            }

            ArrayList<Integer> res = new ArrayList<>();

            //window在s上滑动
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                int chID = cur - 'a';

                window.addLast(cur);
                windowCnt[chID]++;

                //如果window内的字母出现次数溢出，开始从左端出列字母，维持window的性质
                while (!window.isEmpty() && windowCnt[chID] > pCnt[chID]) {
                    int rmID = window.removeFirst() - 'a';
                    windowCnt[rmID]--;
                }

                if (window.size() == p.length()) res.add(i - p.length() + 1);
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}