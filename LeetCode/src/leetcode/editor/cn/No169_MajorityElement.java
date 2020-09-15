package leetcode.editor.cn;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 734 👎 0

public class No169_MajorityElement {
    public void main(String[] args) {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int votes = 0;    //投票
            int x = 0;  //众数
            for (int num : nums) {
                if (votes == 0) x = num;    //当votes为0时，假设此时的num为众数x
                //如果此时的num==众数，votes自增1，否则自减1
                votes += num == x ? 1 : -1;
            }
            return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}