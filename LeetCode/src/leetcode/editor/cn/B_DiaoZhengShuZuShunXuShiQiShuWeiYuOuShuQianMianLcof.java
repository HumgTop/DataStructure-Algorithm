package leetcode.editor.cn;


public class B_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new B_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        solution.exchange(LeetCodeUtils.get1dArr("[8,10,3,20,12,4,10,8,4,0,5,17,7,20,3]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            //双指针
            int right = nums.length - 1;
            int left = 0;

            while (left < right) {
                //right始终指向奇数
                while ((nums[right] & 1) == 0) {
                    right--;
                    if (right <= left || right == 0) return nums;
                }
                //如果left指向偶数，则交换
                if ((nums[left] & 1) == 0) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    right--;
                }
                left++;
            }

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}