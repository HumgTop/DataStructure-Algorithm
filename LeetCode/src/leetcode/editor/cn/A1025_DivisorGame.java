package leetcode.editor.cn;

//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。 
//
// 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作： 
//
// 
// 选出任一 x，满足 0 < x < N 且 N % x == 0 。 
// 用 N - x 替换黑板上的数字 N 。 
// 
//
// 如果玩家无法执行这些操作，就会输掉游戏。 
//
// 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
// 
//
// 示例 2： 
//
// 输入：3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 1000 
// 
// Related Topics 数学 动态规划 
// 👍 231 👎 0

public class A1025_DivisorGame {
    public static void main(String[] args) {
        Solution solution = new A1025_DivisorGame().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean flag = true; //爱丽丝的局为true，否则为false

        public boolean divisorGame(int N) {
            while (N > 1) {
                flag = !flag; //最后一次如果bob无法操作，此时flag为false
                N--;
            }
            //此时N为1
            return !flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}