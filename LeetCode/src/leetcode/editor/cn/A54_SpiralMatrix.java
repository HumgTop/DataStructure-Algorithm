package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class A54_SpiralMatrix {
    public static void main(String[] args) {

        Solution solution = new A54_SpiralMatrix().new Solution();
        int[][] input = LeetCodeUtils.get2dArr("[[1,2,3],[4,5,6],[7,8,9]]");
        System.out.println(solution.spiralOrder(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> res = new ArrayList<>();
        int right = 1, down = 2, left = 3, up = 4;  //标记当前遍历处于何种状态，向右？向下？
        int state = right;

        int[][] matrix;
        int[][] visited;    //判断matrix中该元素是否被访问
        int m;
        int n;

        int r = 0;
        int c = 0;

        public List<Integer> spiralOrder(int[][] matrix) {
            //dfs深搜

            m = matrix.length;
            n = matrix[0].length;
            visited = new int[m][n];
            this.matrix = matrix;
            //共添加m*n个元素
            for (int i = 0; i < m * n; i++) {
                addVal();
            }

            return res;
        }

        void addVal() {
            res.add(matrix[r][c]);   //当前元素入列
            visited[r][c] = 1;
            //校验当前状态，找到下个加入集合的坐标
            switch (state) {
                case 1:
                    //如果右侧元素已经被访问，切换state状态
                    if (c == n - 1 || visited[r][c + 1] == 1) {
                        state = down;
                        r++;
                    } else c++;
                    break;
                case 2:
                    if (r == m - 1 || visited[r + 1][c] == 1) {
                        state = left;
                        c--;
                    } else r++;
                    break;
                case 3:
                    if (c == 0 || visited[r][c - 1] == 1) {
                        state = up;
                        r--;
                    } else c--;
                    break;
                case 4:
                    if (r == 0 || visited[r - 1][c] == 1) {
                        state = right;
                        c++;
                    } else r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}