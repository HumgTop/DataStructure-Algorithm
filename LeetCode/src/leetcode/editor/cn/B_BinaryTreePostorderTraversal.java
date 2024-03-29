package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class B_BinaryTreePostorderTraversal {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            //遍历顺序，左-右-根
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.addLast(root);
                    root = root.left;
                }
                root = stack.removeLast();
                if (root.right != null && root.right != pre) {
                    stack.addLast(root);
                    root = root.right;
                } else {
                    res.add(root.val);
                    pre = root;
                    root = null;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}