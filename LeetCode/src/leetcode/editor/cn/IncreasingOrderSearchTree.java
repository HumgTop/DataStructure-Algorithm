package leetcode.editor.cn;

//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。 
//
// 
//
// 示例 ： 
//
// 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \ 
//1        7   9
//
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9  
//
// 
//
// 提示： 
//
// 
// 给定树中的结点数介于 1 和 100 之间。 
// 每个结点都有一个从 0 到 1000 范围内的唯一整数值。 
// 
// Related Topics 树 深度优先搜索 
// 👍 107 👎 0

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution solution = new IncreasingOrderSearchTree().new Solution();

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
        public TreeNode increasingBST(TreeNode root) {
            ArrayList<Integer> vals = new ArrayList<>();
            rescur(vals, root);
            TreeNode res = new TreeNode(0), cur = res;
            for (Integer val : vals) {
                cur.right = new TreeNode(val);
                cur = cur.right;
            }
            return res.right;
        }

        public void rescur(List<Integer> vals, TreeNode node) {
            if (node == null) return;
            rescur(vals, node.left);
            vals.add(node.val);
            rescur(vals, node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}