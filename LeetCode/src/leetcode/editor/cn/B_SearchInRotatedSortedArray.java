package leetcode.editor.cn;

import org.junit.Test;


public class B_SearchInRotatedSortedArray {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{3, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        int binarySearch(int[] nums, int left, int right, int target) {
            if (left > right) return -1;    //没有该值，返回-1
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;

            //说明nums[left:mid]为有序段
            if (nums[left] <= nums[mid]) {  //[3,1]这种情况，需要<=号来处理
                //在左半区搜索
                if (nums[left] <= target && target < nums[mid]) {
                    return binarySearch(nums, left, mid - 1, target);
                }
                return binarySearch(nums, mid + 1, right, target);
            } else {
                //说明nums[mid:right]为有序段
                if (nums[mid] < target && target <= nums[right]) {
                    return binarySearch(nums, mid + 1, right, target);
                }
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}