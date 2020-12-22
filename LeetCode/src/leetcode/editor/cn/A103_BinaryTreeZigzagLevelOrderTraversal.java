package leetcode.editor.cn;


import java.util.*;

public class A103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

        Solution solution = new A103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(20);
        node3.left = node2;
        node3.right = node1;

        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(3);
        node5.left = node4;
        node5.right = node3;

        List<List<Integer>> res = solution.zigzagLevelOrder(node5);
        res.forEach(System.out::println);
    }

    public static class TreeNode {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            ArrayList<Integer> level = new ArrayList<>();
            ArrayList<List<Integer>> res = new ArrayList<>();

            int right = 1;
            int left = 0;

            int status = right; //表示本层遍历状态（向右或者向左）

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    level.add(cur.val);
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }

                if (status == right) {
                    res.add(new ArrayList<>(level));
                    status = left;  //更改下次的遍历状态
                } else {
                    //将level反转后加入res中
                    Collections.reverse(level);
                    res.add(new ArrayList<>(level));
                    status = right;
                }

                level.clear();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}