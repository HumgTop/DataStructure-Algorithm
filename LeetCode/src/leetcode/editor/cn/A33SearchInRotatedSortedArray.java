package leetcode.editor.cn;
//给你一个升序排列的整数数组 nums ，和一个整数 target 。 
//
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1037 👎 0

public class A33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new A33SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{1}, 1));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                //找到答案后返回
                if (nums[mid] == target) return mid;

                //如果从0到mid是有序区间
                if (nums[mid] >= nums[0]) {
                    //如果target在mid左侧，缩小右区间
                    if (nums[0] <= target && target < nums[mid]) right = mid - 1;
                    //否则缩小左区间
                    else left = mid + 1;
                }
                //如果从旋转点在0到mid之间，说明从mid到right为有序区间
                else {
                    //如果target在mid右侧，缩小左区间
                    if (nums[mid] < target && target <= nums[nums.length - 1]) left = mid + 1;
                    else right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}