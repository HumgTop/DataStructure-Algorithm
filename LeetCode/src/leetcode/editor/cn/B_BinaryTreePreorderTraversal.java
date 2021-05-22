package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


public class B_BinaryTreePreorderTraversal {
    @Test
    public void test() {
        Solution solution = new Solution();

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
        public List<Integer> preorderTraversal(TreeNode root) {
            //根 左 右
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Deque<TreeNode> stack = new LinkedList<>();

            stack.addLast(root);
            while (!stack.isEmpty()) {
                root = stack.removeLast();
                res.add(root.val);
                if (root.right != null) stack.addLast(root.right);
                if (root.left != null) stack.addLast(root.left);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}