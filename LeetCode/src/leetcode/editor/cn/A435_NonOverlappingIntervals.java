package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

public class A435_NonOverlappingIntervals {
    public static void main(String[] args) {

        Solution solution = new A435_NonOverlappingIntervals().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

            int curRight = intervals[0][1];
            int effectiveInterval = 1;  //有效的区间数量

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= curRight) {
                    effectiveInterval++;    //有效的区间数量+1
                    curRight = intervals[i][1];
                }
            }

            return intervals.length - effectiveInterval;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}