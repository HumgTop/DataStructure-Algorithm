package leetcode.editor.cn;
//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 391 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class A144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new A144BinaryTreePreorderTraversal().new Solution();
        // TO TEST
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

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>(); //在处理左子树的时候，保存父节点的信息

            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    res.add(node.val);
                    stack.add(node);    //添加完父节点，node指向左子树
                    node = node.left;
                }
                //如果左子树为空，从栈中弹出父节点，node指向右子树
                node = stack.removeLast().right;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}