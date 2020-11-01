package leetcode.editor.cn;
//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1124 👎 0

import java.util.*;

public class A300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new A300LongestIncreasingSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length < 2) return nums.length;

            List<Integer> cell = new ArrayList<>();    //在遍历过程中维护一个实时的最长子序列
            cell.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                //如果nums[i]大于cell的尾部元素，将其加入cell
                if (nums[i] > cell.get(cell.size() - 1)) {
                    cell.add(nums[i]);
                    continue;
                }
                //否则找到cell中比nums[i]大的最小元素，将其覆盖
                int left = 0, right = cell.size() - 1;
                int pos = 0;    //如果cell中所有的元素都比nums[i]大，则将cell[0]覆盖
                while (left < right) {
                    int mid = (left + right - 1) / 2;
                    if (cell.get(mid) < nums[i]) {
                        left = mid + 1;
                    } else right = mid;
                }
                cell.set(left, nums[i]);
            }

            return cell.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}