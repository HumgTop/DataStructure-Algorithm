package leetcode.editor.cn;

import java.util.Arrays;

public class B_DiagonalTraverse {
    public static void main(String[] args) {
        int[][] dArr = LeetCodeUtils.get2dArr("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] res = new B_DiagonalTraverse().new Solution().findDiagonalOrder(dArr);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] res;
        int idx = 0;
        int m;
        int n;
        int r;
        int c;
        int state = 1;

        public int[] findDiagonalOrder(int[][] mat) {
            m = mat.length;
            n = mat[0].length;
            res = new int[m * n];

            for (int i = 0; i < res.length; i++) {
                solution(mat);
            }
            return res;
        }

        private void solution(int[][] mat) {
            res[idx++] = mat[r][c];
            switch (state) {
                //往右上走
                case 1: {

                    //先继续走右上
                    if (r - 1 >= 0 && c + 1 < n) {
                        r--;
                        c++;
                        return;
                    }
                    //向右
                    if (c + 1 < n) {
                        c++;
                        state = 2;
                        return;
                    }
                    //向下
                    r++;
                    state = 2;
                    break;
                }
                case 2: {
                    //左下
                    if (r + 1 < m && c - 1 >= 0) {
                        r++;
                        c--;
                        return;
                    }
                    //下
                    if (r + 1 < m) {
                        r++;
                        state = 1;
                        return;
                    }
                    //右
                    c++;
                    state = 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}