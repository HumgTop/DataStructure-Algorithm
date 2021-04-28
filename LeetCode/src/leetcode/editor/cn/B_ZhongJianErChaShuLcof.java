package leetcode.editor.cn;

import java.util.HashMap;

public class B_ZhongJianErChaShuLcof {
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


    class Solution {
        int nextNodeIdx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] preorder;
        int[] inorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            //初始化中序遍历索引表
            for (int idx = 0; idx < inorder.length; idx++) {
                map.put(inorder[idx], idx);
            }
            int len = preorder.length;
            return recur(0, len - 1, 0, len - 1);
        }

        //(left,right)表示当前节点子树元素的索引范围
        //return:返回下层已经构造好的子树节点
        TreeNode recur(int preLeft, int preRight, int inorderLeft, int inorderRight) {
            //终止条件
            if (preLeft > preRight) return null;

            TreeNode parent = new TreeNode(preorder[preLeft]);    //该层的父节点
            Integer parentInorderIdx = map.get(parent.val); //父节点的中序遍历索引
            int subLeftTreeSize = parentInorderIdx - inorderLeft;   //左子树元素总数

            parent.left = recur(preLeft + 1, preLeft + subLeftTreeSize,
                    inorderLeft, parentInorderIdx - 1);

            parent.right = recur(preLeft + subLeftTreeSize + 1, preRight,
                    parentInorderIdx + 1, inorderRight);

            return parent;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}