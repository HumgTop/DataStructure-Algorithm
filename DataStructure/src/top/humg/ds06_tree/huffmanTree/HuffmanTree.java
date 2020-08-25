package top.humg.ds06_tree.huffmanTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Huffman树的构造方法
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTreeRoot = createHuffmanTree(arr);
        preOrder(huffmanTreeRoot);  //67，29,38,15,7,8,23,10,4,1,3,6,13
    }

    /**
     * 将一个数组构造为Huffman树
     *
     * @param arr
     * @return Huffman树的根节点
     */
    public static Node createHuffmanTree(int[] arr) {
        ArrayList<Node> list = new ArrayList<>();
        //* 创建Node节点（arr数组值作为其权值）并添加到list集合中
        for (int value : arr) {
            list.add(new Node(value));
        }
        //* 根据Node类中重写compareTo方法进行升序排列
        Collections.sort(list);
        //循环处理，直到list.size()==1为止

        while (list.size() > 1) {
            //* 取出根节点权值最小的2棵二叉树
            Node left = list.get(0);
            Node right = list.get(1);
            //* 构建一棵新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            list.add(parent);

            //* 从list中删除处理过的二叉树
            list.remove(left);
            list.remove(right);
            Collections.sort(list);
        }
        return list.get(0);
//        System.out.println(list.toString());
    }

    /**
     * 复习
     * 2020年8月25日10:43:18
     *
     * @param arr
     * @return
     */
    public static Node createHuffmanTreeReview(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        //创建Node节点并添加到集合中
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //对集合进行排序
        Collections.sort(nodes);
        while (nodes.size() > 1) {
            //获得根节点权值最小的2棵二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //创建父节点
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //移除和添加
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
            //重新排序
            Collections.sort(nodes);
        }
        //此时集合中只有一个元素：root节点
        return nodes.get(0);
    }

    @Test
    public void test1() {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTreeRoot = createHuffmanTreeReview(arr);
        preOrder(huffmanTreeRoot);  //67，29,38,15,7,8,23,10,4,1,3,6,13
    }

    /**
     * 从根节点开始前序遍历
     *
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }
    }
}
