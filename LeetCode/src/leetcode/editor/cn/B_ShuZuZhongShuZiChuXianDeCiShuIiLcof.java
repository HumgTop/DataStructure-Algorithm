package leetcode.editor.cn;


import java.util.HashSet;

public class B_ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new B_ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        System.out.println(solution.singleNumber(new int[]{3, 4, 3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for (int num : nums) {
                for (int j = 0; j < 32; j++) {
                    counts[j] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res |= counts[31 - i] % m;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}