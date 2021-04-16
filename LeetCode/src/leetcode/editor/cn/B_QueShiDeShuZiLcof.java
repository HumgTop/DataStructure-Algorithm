package leetcode.editor.cn;

public class B_QueShiDeShuZiLcof {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            return search(nums, 0, nums.length - 1);
        }

        int search(int[] nums, int left, int right) {
            if (left > right) {
                return left;
            }

            int mid = (left + right) / 2;
            if (nums[mid] == mid) { //乱序数在右半区
                return search(nums, mid + 1, right);
            } else {
                return search(nums, left, mid - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}