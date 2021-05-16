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
            TreeNode pre = null;    //上一次添加到res中的节点
            while (!stack.isEmpty() || root != null) {
                //优先处理左子树
                while (root != null) {
                    stack.addLast(root);
                    root = root.left;
                }
                root = stack.removeLast();
                //判断是否有右子树，如果有root指向右子树进入下一轮循环
                if (root.right != null && pre != root.right) {
                    stack.addLast(root);    //重新入栈
                    root = root.right;
                } else {
                    //右子树为null，或者已添加到res中
                    res.add(root.val);
                    pre = root;   //标记已添加
                    root = null;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}