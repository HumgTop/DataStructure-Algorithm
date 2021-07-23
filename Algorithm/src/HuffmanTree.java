import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Autor HumgTop
 * @Date 2021/7/19 12:09
 * @Version 1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (int val : arr) {
            minHeap.add(new Node(val));
        }

        while (minHeap.size() > 1) {
            Node node1 = minHeap.remove();
            Node node2 = minHeap.remove();
            //构建父节点
            Node parent = new Node(node1.value + node2.value);
            //初始化父节点
            parent.left = node1;
            parent.right = node2;
            //重新入列
            minHeap.add(parent);
        }

        dfs(minHeap.remove());
    }

    private static void dfs(Node node) {
        if (node == null) return;

        System.out.println(node.value);
        dfs(node.left);
        dfs(node.right);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
