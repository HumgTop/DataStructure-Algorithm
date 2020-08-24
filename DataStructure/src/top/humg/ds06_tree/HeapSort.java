package top.humg.ds06_tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序方法
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //1.构建大顶堆（从下往上调整）
        //对所有非叶节点进行调整：从最后一个非叶节点开始操作（因为 n/2到n-1都是叶子节点，所以0~n/2-1都是非叶节点）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            percDown(arr, i, arr.length);
        }
        //2.将堆顶元素与末尾元素交换（每次确认数组的一个位置：从右往左）
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            //此时数组中已经确定了末尾的元素，所以构建堆的长度为arr.length-1
            //因为只有堆顶元素不合格，所以此时从上往下调整
            percDown(arr, 0, j);
        }
    }

    /**
     * 将一个二叉树调整成大顶堆
     *
     * @param arr    源数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整（length在逐渐的减少）
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //arr[i]的左子节点是arr[2i+1]
        //调整当前节点及其子树，满足大顶堆定义
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子节点小于右子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;    //k指向右子节点
            }
            //如果子节点大于父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;    //让i指向k，继续循环比较
            } else
                //如果2个子节点都小于父节点，说明不用调整
                break;
        }
        //for循环结束后，以i为父节点的树的最大值，已经放在了最顶上
        arr[i] = temp;
    }

    /**
     * 《数据结构与算法分析》中的写法
     *
     * @param arr
     * @param cur
     * @param length
     */
    private static void percDown(int[] arr, int cur, int length) {
        int childIndex; //声明子节点的下标
        int temp;
        //循环条件：保证cur节点的左子节点下标不越界
        //每循环一次，cur的指针下移指向它的2个子节点中较大的那个
        for (temp = arr[cur]; leftChildIndex(cur) < length; cur = childIndex) {
            //拿到cur节点的左子节点下标
            childIndex = leftChildIndex(cur);
            //保证右子节点下标不越界
            //childIndex为左右子节点中的较大值的下标
            if (childIndex < length - 1 && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            }
            //如果子节点的较大值比cur的值大，将cur的值替换为子节点的值
            if (arr[childIndex] > temp) {
                //较大值元素上浮（temp暂存的最初的cur节点的值）（类似插入排序，没找到正确的位置时元素后移。）
                arr[cur] = arr[childIndex];
            } else
                //此时child < temp，刚好找到了temp的位置cur退出循环
                break;
        }
        //1.（循环中途break）即temp>child，令cur=temp，保证cur>child体现了大顶堆的性质
        //2.（循环执行到最后）cur已经指向了堆的末尾，之前所有节点的值都比它大，令cur=temp也体现了大顶堆的性质
        arr[cur] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 返回当前节点的左子节点的数组下标
     *
     * @param i
     * @return
     */
    private static int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    /**
     * 复习
     * 2020年8月24日18:06:33
     *
     * @param arr
     * @param cur
     * @param length
     */
    private static void percDownReview(int[] arr, int cur, int length) {
        int childIndex;
        int temp;

        for (temp = arr[cur]; leftChildIndex(cur) < length; cur = childIndex) {
            childIndex = leftChildIndex(cur);
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            if (arr[childIndex] > temp) {
                //上浮
                arr[cur] = arr[childIndex];
            } else
                //找到了temp的位置退出循环
                break;
        }
        arr[cur] = temp;
    }

    private static void heapSortReview(int[] arr) {
        //1.构建大顶堆（从下往上）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            percDownReview(arr, i, arr.length);
        }
        //2.交换堆顶元素到末尾（递减）后，再次调整堆（从上往下）
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            percDownReview(arr, 0, i);
        }
    }

    @Test
    public void test1() {
        int[] arr = {4, 6, 8, 5, 9};
        heapSortReview(arr);
        System.out.println(Arrays.toString(arr));
    }
}
