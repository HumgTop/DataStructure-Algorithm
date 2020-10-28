package leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 640 👎 0

public class A34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new A34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) / 2;

                if (nums[mid] == target) {
                    //向mid左右遍历，找到开始和结束的位置
                    int begin = mid, end = mid;

                    while (begin - 1 >= 0) {
                        if (nums[begin - 1] == target) begin--;
                        else break;
                    }
                    while (end + 1 <= nums.length - 1) {
                        if (nums[end + 1] == target) end++;
                        else break;
                    }

                    return new int[]{begin, end};
                } else if (nums[mid] < target) left = mid + 1;

                else right = mid - 1;
            }

            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}