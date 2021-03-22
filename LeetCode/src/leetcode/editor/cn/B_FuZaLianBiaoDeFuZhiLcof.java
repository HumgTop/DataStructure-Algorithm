package leetcode.editor.cn;


import java.util.*;

public class B_FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {


    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;

            HashMap<Node, Node> visited = new HashMap<>();//原节点：拷贝节点。存入该表表示已被拷贝过
            return dfs(head, visited);
        }

        Node dfs(Node cur, Map<Node, Node> visited) {
            if (cur == null) return null;
            if (visited.containsKey(cur)) return visited.get(cur);

            //拷贝此节点并存入哈希表中
            Node clone = new Node(cur.val);
            visited.put(cur, clone);
            clone.next = dfs(cur.next, visited);
            clone.random = dfs(cur.random, visited);

            return clone;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}