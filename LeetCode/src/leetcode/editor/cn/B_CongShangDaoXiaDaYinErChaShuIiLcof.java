package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B_CongShangDaoXiaDaYinErChaShuIiLcof {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            ArrayList<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                level.clear();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    level.add(cur.val);
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
                res.add(new ArrayList<>(level));    //添加本层元素
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}