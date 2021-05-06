package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


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
            if (root == null) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();

            Deque<TreeNode> stack = new LinkedList<>();
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