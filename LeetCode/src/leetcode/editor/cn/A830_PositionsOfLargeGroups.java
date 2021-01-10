package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A830_PositionsOfLargeGroups {
    public static void main(String[] args) {

        Solution solution = new A830_PositionsOfLargeGroups().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            //记录每个新字符开始的索引
            s = s + " ";    //加入哨兵
            char preCh = ' ';
            int beginIdx = 0;
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != preCh) {
                    if (i - beginIdx >= 3) res.add(Arrays.asList(beginIdx, i - 1)); //满足要求加入res中
                    preCh = s.charAt(i);
                    beginIdx = i;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}