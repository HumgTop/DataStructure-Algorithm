package leetcode.editor.cn;


public class B_ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {


    }

    public class TreeNode {
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
        public TreeNode mirrorTree(TreeNode root) {
            return recur(root);
        }

        TreeNode recur(TreeNode root) {
            if (root == null) return null;

            TreeNode temp = root.left;
            root.left = recur(root.right);
            root.right = recur(temp);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}