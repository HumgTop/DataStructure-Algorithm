package leetcode.editor.cn;

public class A_111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new A_111MinimumDepthOfBinaryTree().new Solution();
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
        int minDepth = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            dfs(root, 1);
            return minDepth;
        }

        //返回本节点的最小深度
        void dfs(TreeNode node, int depth) {
            //如果此节点深度已经>=minDepth，则无需再往下递归（剪枝）
            if (depth >= minDepth) return;
            //终止条件：找到叶子节点返回此深度
            if (node.left == null && node.right == null) {
                minDepth = depth;
                return;
            }

            if (node.left != null) dfs(node.left, depth + 1);
            if (node.right != null) dfs(node.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}