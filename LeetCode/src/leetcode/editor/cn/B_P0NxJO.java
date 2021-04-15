package leetcode.editor.cn;


import java.util.Arrays;
import java.util.PriorityQueue;

public class B_P0NxJO {
    public static void main(String[] args) {
        int[] input = LeetCodeUtils.get1dArr("[100,100,100,-250,-60,-140,-50,-50,100,150]");
        Solution solution = new B_P0NxJO().new Solution();
        System.out.println(solution.magicTower(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicTower(int[] nums) {
            if (Arrays.stream(nums).sum() + 1 <= 0) return -1;

            //维护一个最大堆，记录遍历过程中遇到的怪物伤害
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            long blood = 1;
            int cnt = 0;

            for (int num : nums) {
                //判断遇到能否打完当前怪物，保证生命值大于0
                if (num < 0) {
                    minHeap.add(num);
                    if (blood + num <= 0) {
                        blood -= minHeap.remove();
                        cnt++;
                    }
                }
                blood += num;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}