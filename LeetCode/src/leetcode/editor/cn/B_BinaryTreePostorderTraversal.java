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
            if (root == null) return new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            TreeNode prev = null;   //前一个遍历的节点

            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }
                cur = stack.removeLast();   //此节点左子树为空
                if (cur.right == null || cur.right == prev) {
                    //如果右子树也为空（或者右子树已遍历），则添加根节点值
                    res.add(cur.val);
                    prev = cur;
                    cur = null;
                } else {
                    //如果右子树不为空，或者未曾遍历，则优先处理右子树
                    stack.addLast(cur);
                    cur = cur.right;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}