package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class B_BuKePaiZhongDeShunZiLcof {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> repeat = new HashSet<>();
            int max = 0, min = 14;
            for (int num : nums) {
                if (num == 0) continue; // 跳过大小王
                max = Math.max(max, num); // 最大牌
                min = Math.min(min, num); // 最小牌
                if (repeat.contains(num)) return false; // 若有重复，提前返回 false
                repeat.add(num); // 添加此牌至 Set
            }
            return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}