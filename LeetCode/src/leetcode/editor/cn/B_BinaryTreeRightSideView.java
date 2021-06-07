package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


public class B_BinaryTreeRightSideView {
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
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<>();

            //层序遍历，只取每层的最后一个元素
            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    //每层最后一个元素加入到res中
                    if (i == size - 1) {
                        res.add(cur.val);
                    }
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}