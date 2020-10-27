package leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 783 👎 0

public class A283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new A283MoveZeroes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 1) {
                return;
            }

            int i = 0, j = 0;   //j指向非0元素（快指针），i指向交换后的位置（慢指针）
            while (j < nums.length) {
                //如果双指针指向同一个位置，且该值不为0，双指针+1
                if (i == j && nums[i] != 0) {
                    i++;
                    j++;
                } else if (nums[j] == 0) j++;   //j指针如果指向0，j+1
                else {  //如果i!=j，且j指向非0元素
                    nums[i++] = nums[j++];
                }

            }
            //当j遍历完成后，将此时i之后的元素全置0
            while (i < nums.length) {
                nums[i++] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}