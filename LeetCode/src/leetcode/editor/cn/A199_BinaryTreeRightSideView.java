package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A199_BinaryTreeRightSideView {
    public static void main(String[] args) {

        Solution solution = new A199_BinaryTreeRightSideView().new Solution();

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
     * 广度优先搜索，每层最后一个元素
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) return new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();

            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    if (i == size - 1) res.add(cur.val);    //每层最后一个加入res
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}