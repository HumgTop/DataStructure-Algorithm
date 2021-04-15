package leetcode.editor.cn;


public class B_ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new B_ShuDeZiJieGouLcof().new Solution();
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = node4;
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;

        TreeNode B = new TreeNode(3);

        solution.isSubStructure(node1, B);
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
        boolean res = false;

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //对A树和B树前序遍历，判断B结果是否是A结果的子数组
            if (A == null || B == null) return false;
            preOrder(A, B);
            return res;
        }

        //对A树进行前序遍历
        void preOrder(TreeNode a, TreeNode b) {
            if (res || a == null) return;   //遍历到叶子节点或者已确定子树结构

            //判断此时b是否是a的子树
            if (a.val == b.val && isSubHelper(a, b)) {
                res = true;
                return;
            }

            preOrder(a.left, b);
            preOrder(a.right, b);
        }

        //此时b节点是否是a节点的子树
        boolean isSubHelper(TreeNode a, TreeNode b) {
            if (a == null && b != null) return false;   //此时a遍历完，b未遍历完，说明b不是a的子树
            if (b == null) return true; //此时a未遍历完，说明b是a的子树

            if (a.val == b.val) {
                return isSubHelper(a.left, b.left) && isSubHelper(a.right, b.right);
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}