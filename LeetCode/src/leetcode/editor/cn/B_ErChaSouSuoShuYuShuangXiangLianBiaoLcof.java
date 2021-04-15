package leetcode.editor.cn;


public class B_ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {


    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/
    class Solution {
        Node head;
        Node pre;   //前节点

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            //对头节点和尾节点作连接
            head.left = pre;
            pre.right = head;
            return head;

        }

        //中序遍历
        void dfs(Node cur) {
            if (cur == null) return;    //空节点返回
            dfs(cur.left);
            //判断是否是头节点
            if (pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}