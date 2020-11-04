package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class A_57InsertInterval {
    public static void main(String[] args) {
        Solution solution = new A_57InsertInterval().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        int[][] res = solution.insert(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> list = new ArrayList<>();
            boolean flag = false;
            if (intervals.length == 0) return new int[][]{newInterval};

            for (int i = 0; i < intervals.length; i++) {
                //如果无交集且interval的区间比newInterval小
                if (flag || intervals[i][1] < newInterval[0]) list.add(intervals[i]);
                    //如果无交集且interval的区间比newInterval大
                else if (intervals[i][0] > newInterval[1]) {
                    list.add(newInterval);
                    list.add(intervals[i]);
                    flag = true;
                }
                //如果有交集，且newInterval不是interval的子区间
                else if (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[0]
                        && intervals[i][1] < newInterval[1]) {
                    //将intervals合并入newInterval
                    newInterval[0] = intervals[i][0];
                } else if (intervals[i][0] <= newInterval[1] && intervals[i][0] > newInterval[0]
                        && intervals[i][1] > newInterval[1]) {
                    newInterval[1] = intervals[i][1];
                }
                //如果newInterval是interval的子区间
                else if (intervals[i][0] <= newInterval[0] && newInterval[1] <= intervals[i][1]) {
                    list.add(intervals[i]);
                    flag = true;  //表示合并已完成，后续的interval直接添加到list中
                }

                //如果到最后一次遍历，newInterval仍未添加，将其添加到list中
                if (!flag && i == intervals.length - 1) list.add(newInterval);
            }
            return list.toArray(new int[list.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}