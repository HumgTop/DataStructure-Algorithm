package leetcode.editor.cn;

import org.junit.Test;


public class B_YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            int res = 0;    //最后的索引0，迭代n-1次，恢复其在原始序列的索引
            for (int i = 2; i <= n; i++) {
                res = (res + m) % i;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}