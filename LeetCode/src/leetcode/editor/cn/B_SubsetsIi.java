package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


public class B_SubsetsIi {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results;
        Deque<Integer> res;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //组合问题，使用start变量辅助
            results = new ArrayList<>();    //结果集
            res = new LinkedList<>();    //当次选择结果
            Arrays.sort(nums);
            results.add(new ArrayList<>());
            recur(nums, 0);
            return results;
        }

        //start表示本层元素可选择范围为nums[start:]
        void recur(int[] nums, int start) {
            if (start > nums.length) return;

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;  //同层中，值相等的元素只选择一次

                res.addLast(nums[i]);
                results.add(new ArrayList<>(res));  //添加一个结果
                recur(nums, i + 1); //进入下层递归选择
                res.removeLast();   //撤销选择
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}