package leetcode.editor.cn;


public class A222_CountCompleteTreeNodes {
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
        int cnt = 0;

        public int countNodes(TreeNode root) {
            if (root == null) return 0;

            int depth = 0;
            TreeNode node = root;
            //确定完全二叉树的层数
            while (node.left != null) {
                depth++;
                node = node.left;
            }

            //在底层二分查找最后一个节点的位置
            int left = 1 << (depth);
            int right = (1 << (depth + 1)) - 1;
            while (left < right) {
                int mid = (right - left + 1) / 2 + left;    //防止溢出
                if (exisis(root, depth, mid)) {
                    left = mid;
                } else right = mid - 1;
            }
            //退出循环时，第left个节点存在，第left+1个节点不存在

            return left;
        }

        //判断二叉树第k个节点是否存在
        boolean exisis(TreeNode node, int depth, int k) {
            int bits = 1 << (depth - 1);
            //如果未到底层，node==null提前退出循环。或者到达底层后退出循环
            while (node != null && bits != 0) {
                //使用与运算获得在节点在该层走左边还是右边
                if ((bits & k) == 0) {
                    node = node.left;
                } else node = node.right;

                bits >>= 1;
            }

            return node != null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}