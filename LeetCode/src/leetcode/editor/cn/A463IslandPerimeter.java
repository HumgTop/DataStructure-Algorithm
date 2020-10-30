package leetcode.editor.cn;
//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。 
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 : 
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
// 
// Related Topics 哈希表 
// 👍 270 👎 0

public class A463IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new A463IslandPerimeter().new Solution();
        System.out.println(solution.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0},
                {0, 1, 0, 0}, {1, 1, 0, 0}}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int len = 0;    //方格计数器

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //如果当前格子为岛屿
                    if (grid[i][j] == 1) {
                        len += 4;
                        if (j > 0 && grid[i][j - 1] == 1) len -= 2; //如果同行前一个格子也是岛屿，则周长-2
                        if (i < m - 1 && grid[i + 1][j] == 1) len -= 2; //如果下行同列的格子也是岛屿，周长-2
                    }

                }
            }

            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}