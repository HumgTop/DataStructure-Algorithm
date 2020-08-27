package top.humg.ds06_tree.binarySortTree;

/**
 * 二叉排序树
 * 优势：插入和查找都非常的快速
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        Node root = arr2BST(arr);
        root.infixOrder();
        root.delNode(3);
        System.out.println("-------------");
        root.infixOrder();
    }

    /**
     * 传入一个数组，构造一棵二叉排序树
     *
     * @param arr 二叉排序树的数据源
     * @return 二叉排序树的根节点
     */
    public static Node arr2BST(int[] arr) {
        //第一个元素为根节点
        Node root = new Node(arr[0]);
        //遍历数组
        for (int i = 1; i < arr.length; i++) {
            //向root节点添加元素
            root.add(new Node(arr[i]));
        }
        return root;
    }


}
