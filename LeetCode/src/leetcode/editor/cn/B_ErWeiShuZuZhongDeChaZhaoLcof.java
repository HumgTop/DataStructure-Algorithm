package leetcode.editor.cn;


public class B_ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] matrix;
        int target;
        int rows;
        int cols;

        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0) return false;

            this.matrix = matrix;
            this.target = target;
            rows = matrix.length;
            cols = matrix[0].length;

            return recur(rows - 1, 0);
        }

        //从坐标(r,c)开始深搜，如找到target返回true
        boolean recur(int r, int c) {
            if (r < 0 || c > cols - 1) return false;    //如果越界仍未找到，返回false
            //target大于当前值，则向右搜寻，否则向上搜寻
            if (target == matrix[r][c]) return true;

            if (target > matrix[r][c]) return recur(r, c + 1);
            else return recur(r - 1, c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}