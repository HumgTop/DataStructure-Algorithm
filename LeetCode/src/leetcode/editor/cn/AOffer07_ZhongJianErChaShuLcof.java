package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class AOffer07_ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        int[] pre = LeetCodeUtils.get1dArr("[3,9,20,15,7]");
        int[] in = LeetCodeUtils.get1dArr("[9,3,15,20,7]");
        Solution solution = new AOffer07_ZhongJianErChaShuLcof().new Solution();
        solution.buildTree(pre, in);
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
        int[] preorder;
        int[] inorder;
        int preID = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            int n = preorder.length;

            //key为节点值，value为inorder中的索引
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }


            return recur(map, 0, n - 1, 0, n - 1);
        }

        /**
         * @param map
         * @param preLeft  该树的所有子节点在preorder中的左边界（该树的根节点的索引也为preLeft）
         * @param preRight 该树的所有子节点在preorder中的左边界
         * @param inLeft   该树的所有子节点在inorder中的左边界
         * @param inRight  该树的所有子节点在inorder中的右边界
         * @return 返回构造好子树的本节点
         */
        TreeNode recur(Map<Integer, Integer> map, int preLeft, int preRight, int inLeft, int inRight) {
            //终止条件：当preLeft==preRight时说明该节点已经是叶子节点
            if (preLeft > preRight) return null;

            TreeNode node = new TreeNode(preorder[preLeft]);
            int inID = map.get(node.val);   //获取本节点的inID
            //左子树的节点总数
            int leftSubNode = inID - inLeft;
            //在preorder中，左子树节点在[preleft+1,pivotInPre]，右子树节点在[pivotInPre+1,preRight]
            int pivotInPre = preLeft + leftSubNode;

            node.left = recur(map, preLeft + 1, pivotInPre, inLeft, inID - 1);
            node.right = recur(map, pivotInPre + 1, preRight, inID + 1, inRight);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}