package leetcode.editor.cn;


import java.util.*;

public class A6_ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new A6_ZigzagConversion().new Solution();
        System.out.println(solution.convert("AB", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;

            List<Queue<Character>> queues = new ArrayList<>();
            //初始化队列集合
            for (int i = 0; i < numRows; i++) {
                queues.add(new LinkedList<>());
            }

            int sIdx = 0;
            int qIdx = 0;
            boolean flag = false;  //为true表示qIdx++,否则qIdx--

            char cur;
            while (sIdx < s.length()) {
                cur = s.charAt(sIdx);
                queues.get(qIdx).add(cur);
                //qIdx就是从0->numRows-1->0不断重复的过程
                //到首行或者尾行时，方向改变
                if (qIdx == numRows - 1 || qIdx == 0) flag = !flag;

                qIdx += flag ? 1 : -1;
                sIdx++;
            }
            //字符出列拼接成新的字符串
            StringBuilder res = new StringBuilder();
            Queue<Character> curQueue;
            for (int i = 0; i < numRows; i++) {
                curQueue = queues.get(i);
                while (!curQueue.isEmpty()) {
                    res.append(curQueue.remove());
                }
            }

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}