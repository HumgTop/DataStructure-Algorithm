package leetcode.editor.cn;


public class A34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int target;
        int resLeft;
        int resRight;
        boolean flag = false;

        public int[] searchRange(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
            binarySearch(0, nums.length - 1);
            return flag ? new int[]{resLeft, resRight} : new int[]{-1, -1};
        }

        void binarySearch(int left, int right) {
            //终止条件
            if (left > right) return;

            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                binarySearch(mid + 1, right);
            } else if (nums[mid] > target) {
                binarySearch(left, mid - 1);
            } else { //nums[mid]==target
                flag = true;
                if (mid == 0) resLeft = mid;
                else {
                    int i = mid - 1;
                    while (i >= 0 && nums[i] == target) {
                        i--;
                    }
                    resLeft = i + 1;
                }

                if (mid == nums.length - 1) resRight = mid;
                else {
                    int j = mid + 1;
                    while (j < nums.length && nums[j] == target) {
                        j++;
                    }
                    resRight = j - 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}