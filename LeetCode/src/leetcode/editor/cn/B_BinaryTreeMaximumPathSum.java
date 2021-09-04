package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_BinaryTreeMaximumPathSum {
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
        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return res;
        }

        //以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
        private int maxGain(TreeNode root) {
            if (root == null) return 0;

            int leftVal = Math.max(maxGain(root.left), 0);   //左子树的最大贡献值（如果为负值，不选取该节点）
            int rightVal = Math.max(maxGain(root.right), 0); //右子树的最大贡献值

            //本节点的maxGain（root不为起点）
            int nodeMaxGain = root.val + leftVal + rightVal;
            //刷新res
            res = Math.max(res, nodeMaxGain);


            //以root为起点
            return root.val + Math.max(leftVal, rightVal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}