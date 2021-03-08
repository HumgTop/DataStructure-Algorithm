package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class A1018_BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        Solution solution = new A1018_BinaryPrefixDivisibleBy5().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            if (A.length == 0) return new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            ArrayList<Boolean> res = new ArrayList<>();
            for (int i : A) {
                sb.append(i);
                Long cur = Long.parseLong(sb.toString(), 2);
                res.add(cur % 5 == 0);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}