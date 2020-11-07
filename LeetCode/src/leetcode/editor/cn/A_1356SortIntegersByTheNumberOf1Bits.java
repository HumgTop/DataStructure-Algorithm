package leetcode.editor.cn;

import java.util.*;
import java.util.function.ToIntFunction;

public class A_1356SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new A_1356SortIntegersByTheNumberOf1Bits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortByBits(int[] arr) {
            Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

            Arrays.sort(temp, (o1, o2) -> {
                int cnt1 = Integer.bitCount(o1);
                int cnt2 = Integer.bitCount(o2);

                if (cnt1 == cnt2) return o1 - o2;
                else return cnt1 - cnt2;
            });

            return Arrays.stream(temp).mapToInt(Integer::valueOf).toArray();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}