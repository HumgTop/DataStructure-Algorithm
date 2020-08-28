package top.humg.ds06_tree.avl;

import org.junit.Test;

import java.util.Arrays;

/**
 * 平衡二叉树的自旋
 */
public class AVLTree {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        Node root = arr2AVL(arr);
        root.infixOrder();
    }

    /**
     * 传入一个数组，构造一棵二叉排序树
     *
     * @param arr 二叉排序树的数据源
     * @return 二叉排序树的根节点
     */
    public static Node arr2AVL(int[] arr) {
        //第一个元素为根节点
        Node root = new Node(arr[0]);
        //遍历数组
        for (int i = 1; i < arr.length; i++) {
            //向root节点添加元素
            root.add(new Node(arr[i]));
        }
        return root;
    }

    @Test
    public void getHeightTest() {
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 12, 8, 9, 7, 6};
        Node root = arr2AVL(arr);
        System.out.println(root.getHeight());   //二叉树的高度为4
        System.out.println(root.left.getHeight());  //左子树的高度为1
        System.out.println(root.right.getHeight()); //右子树的高度为3
    }

    /**
     * 单旋转方法（左旋转和右旋转）的测试
     */
    @Test
    public void RotateTest() {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6,5,4};
//        int[] arr = new int[1000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 100);
//        }
        int[] arr = {10, 7, 8};
        System.out.println(Arrays.toString(arr));
        Node root = arr2AVL(arr);
        root.infixOrder();
    }
}
