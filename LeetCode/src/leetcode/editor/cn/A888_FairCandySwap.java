package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class A888_FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new A888_FairCandySwap().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();
            Set<Integer> setA = Arrays.stream(A).boxed().collect(Collectors.toSet());
            for (int val : B) {
                int cur = (sumA - sumB) / 2 + val;
                if (setA.contains(cur)) return new int[]{cur, val};
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}