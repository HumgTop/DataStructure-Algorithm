package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_454FourSumIi {
    public static void main(String[] args) {
        Solution solution = new A_454FourSumIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            HashMap<Integer, Integer> cntAB = new HashMap<>();  //key为A+B的和，value为该和出现的次数
            for (int val : A) {
                for (int val1 : B) {
                    cntAB.put(val + val1, cntAB.getOrDefault(val + val1, 0) + 1);
                }
            }

            HashMap<Integer, Integer> cntCD = new HashMap<>();
            for (int val : C) {
                for (int val1 : D) {
                    cntCD.put(val + val1, cntCD.getOrDefault(val + val1, 0) + 1);
                }
            }

            int res = 0;
            for (Integer preSum : cntAB.keySet()) {
                if (cntCD.containsKey(-preSum)) {
                    res += cntAB.get(preSum) * cntCD.get(-preSum);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}