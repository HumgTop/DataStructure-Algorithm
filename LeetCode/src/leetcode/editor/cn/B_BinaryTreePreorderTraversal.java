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
            //迭代法
            if (root == null) return new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.removeLast();
                res.add(cur.val);
                if (cur.right != null) stack.addLast(cur.right);
                if (cur.left != null) stack.addLast(cur.left);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}