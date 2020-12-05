package leetcode.editor.cn;

public class A_538ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new A_538ConvertBstToGreaterTree().new Solution();
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
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            reverseInOrder(root);
            return root;
        }

        //反向中序遍历：右孩子->根节点->左孩子
        void reverseInOrder(TreeNode node) {
            if (node == null) {
                return;
            }

            reverseInOrder(node.right);

            //修改本节点值
            node.val += sum;
            sum = node.val;

            reverseInOrder(node.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}