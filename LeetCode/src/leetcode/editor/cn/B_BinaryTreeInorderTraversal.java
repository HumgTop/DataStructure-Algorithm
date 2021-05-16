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
            if (root == null) return new ArrayList<>();

            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || root != null) {
                //如果有左子树则一直入栈
                while (root != null) {
                    stack.addLast(root);
                    root = root.left;
                }
                //此时已遍历到左子树最深处，开始出栈元素
                root = stack.removeLast();
                res.add(root.val);
                if (root.right != null) {
                    root = root.right;  //将右子树作为根节点进行下一轮循环
                } else {
                    root = null;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

