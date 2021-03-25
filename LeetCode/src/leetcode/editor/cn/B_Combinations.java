package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class B_Combinations {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int k;
        int n;
        List<List<Integer>> res;

        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            this.n = n;
            res = new ArrayList<>();
            dfs(1, 0, new ArrayList<>());
            return res;
        }

        //start：从start开始组合，之前的元素已经组合过
        //selectCnt：当前选择的组合元素总数
        void dfs(int start, int selectCnt, List<Integer> level) {
            if (selectCnt == k) {
                res.add(new ArrayList<>(level));
                return;
            }

            for (int i = start; i <= n; i++) {
                level.add(i);
                dfs(i + 1, selectCnt + 1, level);
                level.remove(level.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}