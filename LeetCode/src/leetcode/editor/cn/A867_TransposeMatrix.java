package leetcode.editor.cn;

public class A867_TransposeMatrix {
    public static void main(String[] args) {
        Solution solution = new A867_TransposeMatrix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int[][] res = new int[cols][rows];
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    res[i][j] = matrix[j][i];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}