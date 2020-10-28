package leetcode.editor.cn;
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1090 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new A101SymmetricTree().new Solution();
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node7 = new TreeNode(4, null, null);


        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node5 = new TreeNode(2, node7, node6);

        TreeNode node1 = new TreeNode(1, node2, node5);

        System.out.println(solution.isSymmetric(node1));

        // TO TEST
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return bfs(root);
        }

        private boolean bfs(TreeNode node) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (node == null) {
                return true;
            }

            queue.add(node);
            Deque<TreeNode> deque = new LinkedList<>();
            while (!queue.isEmpty()) {
                int n = queue.size();   //不能在循环中使用queue.size()，因为会动态变化
                for (int i = 0; i < n; i++) {
                    TreeNode cur = queue.remove();
                    deque.add(cur);
                    if (cur == null) continue;

                    if (cur.left != null) queue.add(cur.left);
                    else queue.add(null);

                    if (cur.right != null) queue.add(cur.right);
                    else queue.add(null);
                }
                //一层元素全部添加到deque中后，开始从左右出列比较元素是否相同
                while (!deque.isEmpty()) {
                    //对第一层特殊判断
                    if (deque.size() == 1) {
                        deque.remove();
                        break;
                    }

                    TreeNode first = deque.remove();
                    TreeNode last = deque.removeLast();

                    if (first == null && last == null) continue;
                    else if (first == null || last == null) return false;
                    else if (first.val == last.val) continue;

                    //如果2者值不相同
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}