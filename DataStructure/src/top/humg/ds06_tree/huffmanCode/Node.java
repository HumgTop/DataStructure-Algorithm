package top.humg.ds06_tree.huffmanCode;

/**
 * huffman树的节点类
 * 为了使用了Collections的sort方法对权值进行排序，实现Comparable接口并重写compareTo方法
 */
public class Node implements Comparable<Node> {
    byte data;  //存放数据本身
    int weight;  //节点权值
    Node left;  //左子节点
    Node right; //右子节点

    public Node(int weight) {
        this.weight = weight;
    }

    public Node(byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;  //表示升序（从小到大）
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
