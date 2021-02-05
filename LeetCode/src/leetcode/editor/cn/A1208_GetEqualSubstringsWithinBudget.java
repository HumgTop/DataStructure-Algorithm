package leetcode.editor.cn;

public class A1208_GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        Solution solution = new A1208_GetEqualSubstringsWithinBudget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int len = s.length();
            int left = 0, right = 0;
            int curRest = maxCost;    //记录当前窗口内剩余的可消费值
            int[] record = new int[len];
            int res = 0;

            while (right < len) {
                char curs = s.charAt(right);
                char curt = t.charAt(right);
                if (curs == curt) { //无需转化直接跳过
                    right++;
                    res = Math.max(res, right - left);
                    continue;
                } else {
                    record[right] = Math.abs((int) curs - (int) curt);    //当前转化消费
                    while (record[right] > curRest) {
                        curRest += record[left];    //消费返还
                        left++; //左指针移动一位
                    }
                    curRest -= record[right];
                }
                right++;
                res = Math.max(res, right - left);  //窗口在滑动过程有可能变小，所以维护res为窗口最大值
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}