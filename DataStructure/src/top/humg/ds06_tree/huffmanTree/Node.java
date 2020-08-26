package top.humg.ds06_tree.huffmanTree;

/**
 * huffman树的节点类
 * 为了使用了Collections的sort方法对权值进行排序，实现Comparable接口并重写compareTo方法
 */
public class Node implements Comparable<Node> {
    int value;  //节点权值
    Node left;  //左子节点
    Node right; //右子节点
    char character; //对应的字符

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (left != null && right == null) {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left.value +
                    ", right=null" +
                    '}';
        } else if (right != null && left == null) {
            return "Node{" +
                    "value=" + value +
                    ", left=null" +
                    ", right=" + right.value +
                    '}';
        } else if (left != null) {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left.value +
                    ", right=" + right.value +
                    '}';
        } else {
            return "Node{" +
                    "value=" + value +
                    ", left=null" +
                    ", right=null" +
                    '}';
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;  //表示升序（从小到大）
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
