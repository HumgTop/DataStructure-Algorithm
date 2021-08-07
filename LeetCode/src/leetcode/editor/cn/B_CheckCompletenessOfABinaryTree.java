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
            //BFS遍历
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int levelSize;  //第n层最多有2的(n-1)次方个节点
            boolean reachNull = false;  //记录是否遇到null节点

            while (!queue.isEmpty()) {
                levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = queue.remove();
                    if (cur == null) {
                        reachNull = true;
                    } else {
                        if (reachNull) {
                            //如果已经遇到过null节点，直接返回false
                            return false;
                        }
                        queue.add(cur.left);
                        queue.add(cur.right);
                    }

                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}