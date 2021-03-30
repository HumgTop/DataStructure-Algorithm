package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class B_TargetSum {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<int[], Integer> map;
        int[] nums;
        int level;
        int S;

        public int findTargetSumWays(int[] nums, int S) {
            map = new HashMap<>();
            this.nums = nums;
            this.level = nums.length;
            this.S = S;
            return dfs(0, 0);   //从(0,0)出发到(level,S)节点的路径数之和
        }

        /**
         * @param i   当前层数
         * @param sum 当前节点值
         * @return 从(i, sum)到达(level, S)的路径总数
         */
        int dfs(int i, int sum) {
            //终止条件
            if (i == level) {
                return sum == S ? 1 : 0;
            }
            //递归前先判断哈希表中是否已有结果
            int[] key = {i, sum};
            //若不存在，则计算结果后存入哈希表
            if (!map.containsKey(key)) {
                int res = dfs(i + 1, sum - nums[i]) + dfs(i + 1, sum + nums[i]);
                map.put(key, res);
            }
            return map.get(key);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}