package leetcode.editor.cn;
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 923 👎 0

public class A287FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new A287FindTheDuplicateNumber().new Solution();
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(solution.findDuplicate(nums));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            //快慢指针法
            int slow = 0, fast = 0;
            while (true) {
                slow = nums[slow];  //慢指针走1步
                fast = nums[nums[fast]];    //快指针走2步
                if (fast == slow) break;    //相遇时退出循环
            }

            int ptr = 0;    //此时从头部出发一个指针
            while (true) {
                slow = nums[slow];
                ptr = nums[ptr];
                if (slow == ptr) break; //当相遇时，此时指向便是环的入口
            }
            return ptr;

            // 二分查找
//            int left = 1, right = nums.length - 1;  //nums中数的值>=1且<=nums.length-1
//            while (left < right) {
//                int mid = (left + right) >>> 1;
//                //遍历整个数组，统计小于mid的值的数目
//                int count = 0;
//                for (int num : nums) {
//                    if (num <= mid) count++;
//                }
//
//                //如果小于等于mid的数>mid，说明重复的数肯定在[1,mid]区间
//                if (count > mid) {
//                    right = mid;    //搜索[left,mid]
//                } else {
//                    left = mid + 1; //搜索[mid+1,right]
//                }
//            }
//            //left和right不断逼近，当left==right时，即为重复数
//            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}