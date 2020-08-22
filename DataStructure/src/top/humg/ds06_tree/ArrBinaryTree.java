package top.humg.ds06_tree;

/**
 * 顺序存储二叉树
 */
public class ArrBinaryTree {
    private final int[] arr;  //存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 按照二叉树前序遍历的方式来遍历数组
     *
     * @param index
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组长度为0，没有元素");
            return;
        }

        System.out.printf("%d\t", arr[index]);
        //向左递归遍历
        //当前节点的左子节点在数组中的下标为 2*index+1
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        //当前节点的右子节点在数组中的下标为 2*index+2
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    /**
     * 重载 preOrder 方法，默认参数为0
     */
    public void preOrder() {
        this.preOrder(0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder();
    }
}
