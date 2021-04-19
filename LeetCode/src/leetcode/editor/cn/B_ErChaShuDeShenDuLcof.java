package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Queue;

public class B_ErChaShuDeShenDuLcof {
    public static void main(String[] args) {


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                //遍历本层所有节点，同时添加下层需遍历的节点
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
            }

            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}