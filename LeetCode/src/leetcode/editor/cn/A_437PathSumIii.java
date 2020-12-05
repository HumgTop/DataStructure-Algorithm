package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new A_437PathSumIii().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        int res = 0;
        int sum;

        public int pathSum(TreeNode root, int sum) {
            this.sum = sum;
            dfs(root);
            return res;
        }

        List<Integer> dfs(TreeNode node) {
            if (node == null) return new ArrayList<>();

            List<Integer> left = dfs(node.left);    //左子树的前缀节点和
            List<Integer> right = dfs(node.right);  //右子树的前缀节点和

            if (node.val == sum) res++;
            ArrayList<Integer> list = new ArrayList<>();    //本节点的前缀节点和
            list.add(node.val);

            for (Integer subSum : left) {
                int temp = node.val + subSum;
                if (temp == sum) res++;
                list.add(temp);
            }
            for (Integer subSum : right) {
                int temp = node.val + subSum;
                if (temp == sum) res++;
                list.add(temp);
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}