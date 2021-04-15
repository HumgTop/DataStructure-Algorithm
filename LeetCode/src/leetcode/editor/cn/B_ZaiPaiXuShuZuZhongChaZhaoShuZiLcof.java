package leetcode.editor.cn;


import java.util.Arrays;

public class B_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new B_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{2, 2}, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int target;

        public int search(int[] nums, int target) {
            if (nums.length == 0) return 0;
            this.nums = nums;
            this.target = target;
            return binarySearch(0, nums.length - 1);
        }

        /**
         * @param left  当前数组查找范围的左边界
         * @param right 当前数组查找范围的右边界
         * @return 返回数组中target出现的次数
         */
        int binarySearch(int left, int right) {
            int mid = (left + right) >> 1;

            if (mid >= 0 && target == nums[mid]) {
                int i = mid - 1, j = mid + 1;
                int res = 1;
                while (i >= 0 && nums[i] == target) {
                    res++;
                    i--;
                }
                while (j < nums.length && nums[j] == target) {
                    res++;
                    j++;
                }
                return res;
            }
            if (left >= right) return 0;    //数组中不存在target元素

            if (target < nums[mid]) return binarySearch(left, mid - 1); //左半区搜索
            else return binarySearch(mid + 1, right);   //右半区搜索
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}