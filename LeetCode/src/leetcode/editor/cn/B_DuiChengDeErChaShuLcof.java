package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new B_DuiChengDeErChaShuLcof().new Solution();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(1);
        node5.left = node3;
        node5.right = node1;
        node6.left = node2;
        node6.right = node4;
        node7.left = node5;
        node7.right = node6;
        solution.isSymmetric(node7);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return recur(root.left, root.right);
        }

        //若左子树L与右子树R对称返回true，利用递归从最底层开始比较
        boolean recur(TreeNode L, TreeNode R) {
            //终止条件
            if (L == null && R == null) return true;
            if (L == null || R == null || L.val != R.val) return false;

            return recur(L.left, R.right) && recur(L.right, R.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}