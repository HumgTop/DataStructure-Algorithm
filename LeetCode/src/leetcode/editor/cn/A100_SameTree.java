package leetcode.editor.cn;


public class A100_SameTree {
    public static void main(String[] args) {

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return dfs(p, q);
        }

        //同时递归的比较两颗树的相同节点
        boolean dfs(TreeNode node1, TreeNode node2) {
            //如果2个节点都为null
            if (node1 == null && node2 == null) return true;
            //如果有1个节点为null，另1个不为null
            if (node1 == null || node2 == null) return false;

            if (node1.val != node2.val) return false;


            return dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}