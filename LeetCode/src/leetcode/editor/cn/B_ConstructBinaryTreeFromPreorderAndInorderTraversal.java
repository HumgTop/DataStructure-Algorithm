package leetcode.editor.cn;

import org.junit.Test;


public class B_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    @Test
    public void test() {
        Solution solution = new Solution();
        solution.buildTree(new int[]{1, 2}, new int[]{2, 1});
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
        int[] preorder;
        int[] inorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //前序：根，左，右
            //中序：左，根，右
            this.preorder = preorder;
            this.inorder = inorder;
            int n = preorder.length;
            return recur(0, n - 1, 0, n - 1);
        }

        /**
         * 构造当前子树，并返回子树根节点到上层
         *
         * @param preLeftIdx
         * @param preRightIdx
         * @param inLeftIdx
         * @param inRightIdx
         * @return
         */
        TreeNode recur(int preLeftIdx, int preRightIdx, int inLeftIdx, int inRightIdx) {
            if (preLeftIdx > preRightIdx) {
                //此时为叶子节点
                return null;
            }
            TreeNode root = new TreeNode(preorder[preLeftIdx]); //构造本子树根节点
            int rootIdxInInorder = getIdxInInorder(preorder[preLeftIdx]);   //根节点在中序遍历数组中的索引
            //左子树的元素个数
            int leftChildCnt = rootIdxInInorder - inLeftIdx;
            int lastLeftElementInPreIdx = preLeftIdx + leftChildCnt;
            root.left = recur(preLeftIdx + 1, lastLeftElementInPreIdx, inLeftIdx, rootIdxInInorder - 1);
            root.right = recur(lastLeftElementInPreIdx + 1, preRightIdx, rootIdxInInorder + 1, inRightIdx);
            return root;
        }

        int getIdxInInorder(int value) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == value) return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}