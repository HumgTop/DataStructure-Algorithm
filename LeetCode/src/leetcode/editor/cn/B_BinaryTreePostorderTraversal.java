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
            TreeNode cur = root;
            TreeNode prev = null;   //前一次访问的节点

            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }
                //此时左子树已处理
                cur = stack.removeLast();   //出栈根节点
                if (cur.right == null || cur.right == prev) {
                    res.add(cur.val);
                    prev = cur;
                    cur = null;
                } else {
                    stack.addLast(cur);
                    cur = cur.right;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}