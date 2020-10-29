package leetcode.editor.cn;
//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 892 👎 0

public class A55JumpGame {
    public static void main(String[] args) {
        Solution solution = new A55JumpGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int maxDistance = 0;    //遍历中，实时维护最远可以到达的位置

            for (int i = 0; i < nums.length; i++) {
                //如果当前位置在可到达范围内
                if (i <= maxDistance) {
                    maxDistance = Math.max(maxDistance, i + nums[i]);
                    //如果已经可以到达最后位置，返回TRUE
                    if (maxDistance >= nums.length - 1) return true;
                }
                //如果当前位置无法到达：比如[0,1]这种情况
                else return false;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}