package algorithm02_sort;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

/**
 * 快速排序
 */
public class No5_QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 22, 0, 23, -5, -567, 70}; //待排序数组
        int[] sort = sort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }


    /**
     * 测试插入排序的速度
     */
    @Test
    public void test1() {
        //对80000个元素进行冒泡排序
        int[] arr = new int[80000];
        //给数组注入随机数
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);    //Math.random方法产生的是0~1之间的小数
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        Date before = new Date(); //排序前的时间
        sort2(arr, 0, arr.length - 1);
        Date after = new Date();    //排序后的时间
        System.out.printf("快速排序耗时%d毫秒%n", after.getTime() - before.getTime());
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        //运行结果为8毫秒左右
    }

    /**
     * 对输入数组进行快速排序
     *
     * @param arr
     * @param left  左侧分区元素下标
     * @param right 右侧分区元素下标
     * @return
     */
    private static int[] sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];  //中轴基准元素
        int temp;   //用于元素交换的临时变量
        //将比pivot值小的元素放到左边，大的元素放到右边
        while (l < r) {    //因为l递增，r递减，当l==r时说明一轮分区结束(partition)
            //**因为l和r并不是同步递增或者递减的，所以需要设置2个循环判断语句去处理l的递增和r的递减（可能l增了5次，r才减了1次）
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            //如果此时l>=r说明分区操作已经完成
            if (l >= r) {
                break;
            }
            //此时arr[l]>=pivot且arr[r]<=pivot，两者进行交换
            swap(arr, l, r);

            //如果存在值==pivot，且已经被交换过一次，需要为其进行指针递增或递减。
            // 否则因为不能通过上面的while循环条件而陷入死循环（l恒小于r），该值在左侧和右侧反复交换
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如不对l和r进行递增递递减，会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //**向左递归
        if (r > left) {
            sort(arr, left, r);
        }
        //向右递归
        if (l < right) {
            sort(arr, l, right);
        }
        return arr;
    }

    /**
     * 来自知乎的第二种写法
     * 每次基准值的选取都是待排序分区的第一个元素
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] sort2(int[] arr, int left, int right) {
        //递归头：直到left>=right，所有元素分区排序结束
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            //左递归
            sort2(arr, left, partitionIndex - 1);
            //右递归
            sort2(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * 分区操作，将比基准值小的放在左侧，比基准值大的放在右侧
     *
     * @param arr
     * @param left
     * @param right
     * @return 基准值的下标
     */
    private static int partition(int[] arr, int left, int right) {
        //将最左侧元素作为基准值pivot
        int pivot = left;
        int lp = pivot + 1, rp = lp;  //相当于l指针
        //r指针从数组最左端（不包括arr[left]）向right处移动
        while (rp <= right) {
            //如果向右移动过程中，r指针处小于基准值的值与index指针处的值进行交换
            if (arr[rp] < arr[pivot]) {
                /*
                如果rPointer==lPointer时，arr[rPointer]<arr[pivot]也需要进行交换（需要让lPointer++，否则下次
                交换时lPointer指向的小于基准值的元素会被交换到右侧）
                 */
                swap(arr, rp++, lp++);
            } else rp++;
        }
        //**此时index-1指向的是比左侧分区的末尾元素（比基准值小的元素）
        //**将基准值交换到正确的位置（满足左侧分区小于基准值，右侧分区大于基准值）
        swap(arr, pivot, lp - 1);
        //返回此时基准值的下标
        return lp - 1;
    }

    /**
     * 对arr[i]和arr[j]的元素进行交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 复习
     * 2020年8月17日15:33:06
     * 2020年8月18日10:29:10
     * 2020年8月22日08:56:20
     * 2020年8月26日15:28:21
     * 2020年9月3日08:41:24
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] sortReview(int[] arr, int left, int right) {
        if (left >= right) return arr;
        int partitionIndex = partitionReview(arr, left, right);
        //左侧递归进行分区
        sortReview(arr, left, partitionIndex - 1);
        sortReview(arr, partitionIndex + 1, right);

        return arr;
    }

    /**
     * 复习
     * 分区方法
     *
     * @param arr
     * @param left
     * @param right
     * @return 基准值下标
     */
    private static int partitionReview(int[] arr, int left, int right) {
        int pivot = left;
        int lIndex = pivot + 1;
        int rIndex;
        for (rIndex = lIndex; rIndex <= right; rIndex++) {
            //如果右侧有小于基准值的元素，将其交换到左侧
            if (arr[rIndex] < arr[pivot]) swap(arr, rIndex, lIndex++);
        }
        //将基准值交换到正确的位置
        swap(arr, pivot, lIndex - 1);
        return lIndex - 1;
    }

    /**
     * 测试复习的代码
     */
    @Test
    public void testReview() {
        int[] arr = {-9, 78, 0, 22, 0, 23, -5, -567, 70}; //待排序数组
        int[] sort = sortReview(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }
}
