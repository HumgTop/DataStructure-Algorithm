package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class A77_Combinations {
    public static void main(String[] args) {

        Solution solution = new A77_Combinations().new Solution();
        for (List<Integer> integers : solution.combine(1, 0)) {
            System.out.println(integers);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int k;
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            recur(1, 1, new ArrayList<>());
            return res;
        }

        /**
         * @param cur       当前选择的数
         * @param selectedK 当前K的值
         */
        void recur(int cur, int selectedK, List<Integer> temp) {
            if (selectedK == k + 1) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = cur; i <= n - k + selectedK; i++) {    //保证剩下的数全部选完可以构造长度为k的序列
                temp.add(i);    //添加当前选择
                recur(i + 1, selectedK + 1, temp);  //递归进行下一步选择
                temp.remove(temp.size() - 1);   //移除选择
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}