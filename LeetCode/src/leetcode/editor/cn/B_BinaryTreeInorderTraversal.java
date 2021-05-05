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
            //遍历顺序：左-根-右
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            TreeNode cur = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }
                //此时cur为null，左子树已处理。继续处理根节点
                cur = stack.removeLast();
                res.add(cur.val);
                if (cur.right == null) {
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}