package leetcode.editor.cn;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 652 👎 0

import java.util.*;

public class A18FourSum {
    public static void main(String[] args) {
        Solution solution = new A18FourSum().new Solution();
        int[] arr = {1, -2, -5, -4, -3, 3, 3, 5};
        List<List<Integer>> lists = solution.fourSum(arr, -11);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        int[] nums;
        int target;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            this.res = new ArrayList<>();
            this.nums = nums;
            Arrays.sort(this.nums);
            this.target = target;

            recur(4, 0, new LinkedList<>(), 0);
            return res;
        }

        public void recur(int restSelect, int start, Deque<Integer> stack, int sum) {
            if (restSelect == 0 && sum == target) {
                res.add(new ArrayList<>(stack));

            }

            for (int i = start; i < nums.length; i++) {
                if (nums.length - i < 4 - stack.size()) return;  //可选元素数小于必选元素数
                if (i > start && nums[i] == nums[i - 1]) continue;

                if ((nums[i] < 0 || sum + nums[i] <= target)) {
                    stack.add(nums[i]);
                    recur(restSelect - 1, i + 1, stack, sum + nums[i]);
                    stack.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}