package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class B_BinaryTreeInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            ArrayList<Integer> res = new ArrayList<>();
            TreeNode cur = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || cur != null) {
                //优先处理左子树
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.removeLast();
                res.add(node.val);
                if (node.right != null) {
                    cur = node.right;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}