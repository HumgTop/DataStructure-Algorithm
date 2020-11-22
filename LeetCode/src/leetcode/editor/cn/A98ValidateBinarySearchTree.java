package leetcode.editor.cn;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 818 👎 0


public class A98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new A98ValidateBinarySearchTree().new Solution();
        // TO TEST
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        node2.right = node1;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node4.left = node3;
        node4.right = node2;

        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(1);
        node7.left = node5;
        node7.right = node6;

        TreeNode node8 = new TreeNode(3);
        node8.left = node7;
        node8.right = node4;
        System.out.println(solution.isValidBST(node8));
    }

    static class TreeNode {
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
        boolean flag = true;
        TreeNode root;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            this.root = root;

            dfs(root, root.val);
            return flag;
        }

        void dfs(TreeNode node, int rootVal) {
            //终止条件：空间点
            if (node == null) return;
            //如果存在左子树
            if (node.left != null) {
                if (node.left.val >= node.val) {
                    flag = false;
                    return;
                }
                //如果存在左子树的右节点且非法
                if (node.left.right != null && node.left.right.val >= node.val) {
                    flag = false;
                    return;
                }
                if (node.left.right != null && node.left.right.right != null && node.left.right.right.val >= node.val) {
                    flag = false;
                    return;
                }
            }

            if (node.right != null) {
                if (node.right.val <= node.val) {
                    flag = false;
                    return;
                }
                //如果存在右子树的左节点且非法
                if (node.right.left != null && node.right.left.val <= node.val) {
                    flag = false;
                    return;
                }
            }

            //如果子节点合法，则继续向下递归
            dfs(node.left, rootVal);
            if (flag) dfs(node.right, rootVal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}