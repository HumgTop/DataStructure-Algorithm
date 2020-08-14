package algorithm02_sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 22, 0, 23, -5, -567, 70}; //待排序数组
        int[] sort = sort(arr, 0, arr.length - 1);
//        int[] sort = sortReview(arr);
        System.out.println(Arrays.toString(sort));
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
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果存在值==pivot，且已经被交换过一次，需要为其进行指针递增或递减。
            // 否则因为不能通过上面的while循环条件而陷入死循环（l恒小于r），该值在左侧和右侧反复交换
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        return arr;
    }
}
