package leetcode.editor.cn;


public class B_ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new B_ShunShiZhenDaYinJuZhenLcof().new Solution();
        for (int val : solution.spiralOrder(LeetCodeUtils.get2dArr("[[1,2,3],[4,5,6],[7,8,9]]"))) {
            System.out.println(val);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[]{};

            int rows = matrix.length;
            int cols = matrix[0].length;
            int[] res = new int[rows * cols];
            int idx = 0;

            int r = 0, c = 0;
            int state = 1;
            while (idx < res.length) {
                res[idx++] = matrix[r][c];
                matrix[r][c] = 111;  //标记已访问
                //state=1,2,3,4；对应向右、下、左、上遍历
                switch (state) {
                    case 1: {
                        //直到下一个元素越界被访问
                        if (c == cols - 1 || matrix[r][c + 1] == 111) {
                            r++;
                            state = 2;
                        } else c++;
                        break;
                    }
                    case 2: {
                        //直到下一个元素越界被访问
                        if (r == rows - 1 || matrix[r + 1][c] == 111) {
                            c--;
                            state = 3;
                        } else r++;
                        break;
                    }
                    case 3: {
                        //直到下一个元素越界被访问
                        if (c == 0 || matrix[r][c - 1] == 111) {
                            r--;
                            state = 4;
                        } else c--;
                        break;
                    }
                    case 4: {
                        //直到下一个元素越界被访问
                        if (r == 0 || matrix[r - 1][c] == 111) {
                            c++;
                            state = 1;
                        } else r--;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}