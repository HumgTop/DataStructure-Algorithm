package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


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
        Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //前序：根，左，右
            //中序：左，根，右
            indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        TreeNode build(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
            if (preL > preR) return null;   //越过叶子节点
            TreeNode root = new TreeNode(preorder[preL]);
            Integer inorderRootIdx = indexMap.get(root.val);
            int subLeftTreeSize = inorderRootIdx - inL; //左子树大小
            root.left = build(preorder, inorder, preL + 1, preL + subLeftTreeSize, inL, subLeftTreeSize + inL - 1);
            root.right = build(preorder, inorder, preL + subLeftTreeSize + 1, preR, inorderRootIdx + 1, inR);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}