package leetcode.editor.cn;


import java.util.*;

public class A113_PathSumIi {
    public static void main(String[] args) {

        Solution solution = new A113_PathSumIi().new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node3.left = node5;

        solution.pathSum(node1, 22);
        for (List<Integer> re : solution.res) {
            System.out.println(re);
        }
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
        List<List<Integer>> res = new ArrayList<>();
        int sum;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            this.sum = sum;

            dfs(root, 0, new LinkedList<>());
            return res;
        }

        void dfs(TreeNode node, int curSum, Deque<Integer> path) {
            if (node == null) return;
            path.addLast(node.val);

            //终止条件：如果是叶子节点的话
            if (node.left == null && node.right == null) {
                if (curSum + node.val == sum) res.add(new ArrayList<>(path));   //path合法则添加到res中
                path.removeLast();
                return;
            }


            dfs(node.left, curSum + node.val, path);
            dfs(node.right, curSum + node.val, path);

            path.removeLast();  //执行完本层后，移除本层选择的元素。
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}