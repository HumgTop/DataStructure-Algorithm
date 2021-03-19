package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_CongShangDaoXiaDaYinErChaShuLcof {
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
        public int[] levelOrder(TreeNode root) {
            //BFS
            if (root == null) return new int[]{};

            ArrayList<Integer> resList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                resList.add(cur.val);   //将bfs遍历值存入list中
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            return resList.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}