package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

public class A452_MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            //按points的start值进行排序
            Arrays.sort(points, (Comparator.comparingInt(o -> o[1])));
            //定义当前射出箭能覆盖的最大右边界
            int pos = points[0][1];
            int res = 1;
            for (int i = 0; i < points.length; i++) {
                //如果points[i][0]<pos，说明当前箭可以射穿该气球。
                //否则需要新射出一箭
                if (pos < points[i][0]) {
                    pos = points[i][1];
                    res++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}