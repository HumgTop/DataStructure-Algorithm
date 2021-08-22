package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class B_MergeIntervals {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] arr = LeetCodeUtils.get2dArr("[[1,3],[2,6],[8,10],[15,18]]");
        solution.merge(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, ((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }));

            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                while (i + 1 < intervals.length && intervals[i][0] == intervals[i + 1][0]) {
                    i++;
                }

                //有交集
                if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                    intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                    intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                }
                //无交集
                else {
                    res.add(intervals[i]);
                }
            }


            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}