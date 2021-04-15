package leetcode.editor.cn;


import java.util.*;

public class B_CongShangDaoXiaDaYinErChaShuIiiLcof {
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

            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            ArrayList<Integer> level = new ArrayList<>();
            ArrayList<List<Integer>> res = new ArrayList<>();
            int levelCnt = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                levelCnt++;
                level.clear();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.removeFirst();
                    level.add(cur.val);
                    if (cur.left != null) queue.addLast(cur.left);
                    if (cur.right != null) queue.addLast(cur.right);
                }
                if ((levelCnt & 1) == 1) {
                    res.add(new ArrayList<>(level));
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    //添加逆序
                    for (int i = level.size() - 1; i >= 0; i--) {
                        temp.add(level.get(i));
                    }
                    res.add(new ArrayList<>(temp));
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}