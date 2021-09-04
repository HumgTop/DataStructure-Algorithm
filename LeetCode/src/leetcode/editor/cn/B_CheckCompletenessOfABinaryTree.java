package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class B_CheckCompletenessOfABinaryTree {
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
        public boolean isCompleteTree(TreeNode root) {
            //BFS
            boolean flag = false;   //标记是否访问到null节点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();

                //如果已经访问到null节点后，再访问到非空节点，说明不是完全二叉树
                if (flag && cur != null) {
                    return false;
                }
                if (cur == null) {
                    flag = true;    //已经访问到null节点
                } else {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}