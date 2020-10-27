package leetcode.editor.cn;
//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。 
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。 
//
// 以数组形式返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释： 
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。 
//对于 nums[3]=2 存在一个比它小的数字：（1）。 
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
// 
//
// 示例 2： 
//
// 输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
// 
//
// 示例 3： 
//
// 输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 70 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class A1365HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        Solution solution = new A1365HowManyNumbersAreSmallerThanTheCurrentNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            // 桶排序
            int[] bucket = new int[101];    //bucket[i]表示数字i出现的次数
            for (int num : nums) {
                bucket[num]++;  //对应的桶计数器加一
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1]; //处理bucket，即数组中小于i的元素数目为bucket[i-1]（小于0的元素为0个）
            }

            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = nums[i] == 0 ? 0 : bucket[nums[i] - 1];    //nums[i]==0的情况特殊处理
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}