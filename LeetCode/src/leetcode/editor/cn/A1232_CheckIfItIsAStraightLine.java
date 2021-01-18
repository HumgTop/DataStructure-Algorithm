package leetcode.editor.cn;

public class A1232_CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution solution = new A1232_CheckIfItIsAStraightLine().new Solution();
        int[][] input = LeetCodeUtils.get2dArr("[[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]");
        System.out.println(solution.checkStraightLine(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length == 2) return true;
            float k = coordinates[1][0] - coordinates[0][0] == 0 ? Integer.MAX_VALUE : (coordinates[1][1] - coordinates[0][1]) / (float) (coordinates[1][0] - coordinates[0][0]);
            for (int i = 2; i < coordinates.length; i++) {
                int x1 = coordinates[i - 1][0];
                int y1 = coordinates[i - 1][1];
                int x2 = coordinates[i][0];
                int y2 = coordinates[i][1];

                if (x1 - x2 == 0) {
                    if (k != Integer.MAX_VALUE) return false;
                } else if ((y2 - y1) / (float) (x2 - x1) != k) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}