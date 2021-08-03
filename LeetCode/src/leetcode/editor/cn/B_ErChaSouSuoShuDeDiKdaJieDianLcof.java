package leetcode.editor.cn;


public class B_ErChaSouSuoShuDeDiKdaJieDianLcof {
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
        int res;
        int cnt = 0;
        int k;

        public int kthLargest(TreeNode root, int k) {
            //遍历顺序为：右子节点-父节点-左子节点
            this.k = k;
            dfs(root);
            return res;
        }

        void dfs(TreeNode cur) {
            if (cur == null) return;

            dfs(cur.right);
            cnt++;
            if (cnt == k) res = cur.val;
            dfs(cur.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}