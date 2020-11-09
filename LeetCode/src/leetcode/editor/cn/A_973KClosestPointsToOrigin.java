package leetcode.editor.cn;

import java.util.Arrays;

public class A_973KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new A_973KClosestPointsToOrigin().new Solution();
        // TO TEST
        int[][] input = LeetCodeUtils.get2dArr("[[68,97],[34,-84],[60,100]," +
                "[2,31],[-27,-38],[-73,-74],[-55,-39],[62,91],[62,92],[-57,-67]]");

        int[][] res = solution.kClosest(input, 5);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] points;

        public int[][] kClosest(int[][] points, int K) {
            this.points = points;
            partition(0, points.length - 1, K);
            return Arrays.copyOfRange(points, 0, K);

        }

        void partition(int left, int right, int K) {
            int pivotId = left;
            int lp = left + 1, rp = lp;
            int pivot = getDis(pivotId);

            while (rp <= right) {
                //将小于pivot的值交换到左侧
                int dis = getDis(rp);
                if (dis < pivot) swap(lp++, rp++);
                else rp++;
            }

            //将基准值交换到中间
            swap(pivotId, lp - 1);
            pivotId = lp - 1;

            /*
            递归执行终止时，pivotId及其左侧有K个元素，此时的points[0...pivotId]即为答案
             */

            //如果基准值及其左侧有超过k个元素，说明dis值第K小的点在基准值的左侧
            if (pivotId - left + 1 > K) partition(left, pivotId - 1, K);
                //** 令n=pivotId-left+1，此时n<K说明，dis值第K小的点在基准值的右侧，在右侧找到dis值第K-n小的元素
            else if (pivotId - left + 1 < K) partition(pivotId + 1, right, K - (pivotId - left + 1));    //对基准值的右侧继续分区
        }

        //返回该点到原点的距离平方
        int getDis(int p) {
            return points[p][0] * points[p][0]
                    + points[p][1] * points[p][1];
        }

        void swap(int id1, int id2) {
            int[] temp = points[id1];
            points[id1] = points[id2];
            points[id2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}