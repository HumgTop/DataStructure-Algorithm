package leetcode.editor.cn;

public class A766_ToeplitzMatrix {
    public static void main(String[] args) {
        Solution solution = new A766_ToeplitzMatrix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int rows;
        int cols;
        int[][] matrix;

        public boolean isToeplitzMatrix(int[][] matrix) {
            rows = matrix.length;
            cols = matrix[0].length;
            this.matrix = matrix;
            //遍历第一行和第一列除末尾外的所有元素
            for (int c = 0; c < cols - 1; c++) {
                if (!recur(0, c)) return false;
            }
            for (int r = 1; r < rows - 1; r++) {
                if (!recur(r, 0)) return false;
            }

            return true;
        }

        /**
         * 判断起点为(r,c)的对角线元素是否全部相同，相同返回true
         *
         * @param r 初始坐标
         * @param c 初始坐标
         * @return
         */
        boolean recur(int r, int c) {
            //遍历到对角线最后一个元素则终止递归
            if (r == rows - 1 || c == cols - 1) return true;

            if (matrix[r][c] == matrix[r + 1][c + 1]) return recur(r + 1, c + 1);
            else return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}