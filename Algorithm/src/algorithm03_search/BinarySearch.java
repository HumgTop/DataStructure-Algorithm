package algorithm03_search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * 只能在有序数列中查找！！
 */
public class BinarySearch {
    //声明并初始化变量，否则list==null，使用list.add方法会产生空指针异常
    private static ArrayList<Integer> list = new ArrayList<>(); //存入查找到的元素索引

    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 1000, 1234};
        int index = search(array, 0, array.length, 1000);
        System.out.println(index);
    }

    /**
     * 网课demo
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    private static int search(int[] arr, int left, int right, int findVal) {
        //如果left==right，还存在可能性 findVal==arr[mid]
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return search(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return search(arr, left, mid - 1, findVal);
        } else
            return mid;
    }

    /**
     * 查找操作
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return 所查找元素在数组内的索引
     */
    private static int mySearch(int[] arr, int value, int left, int right) {
        int curLeft = left; //当前查找范围的左边界
        int curRight = right;   //当前查找范围的右边界
        int mid = (curLeft + curRight) / 2;
        //** 此处不可用=号，因为存在value==arr[left]的可能性
        //设置递归头
        if (left > right) {
            return -1;
        }

        if (value < arr[mid]) {
            //向左递归
            return mySearch(arr, value, left, mid - 1);
        } else if (value > arr[mid]) {
            //向右递归
            return mySearch(arr, value, mid + 1, right);
        } else {
            return mid;
        }
    }

    /**
     * 测试mySearch方法
     */
    @Test
    public void test1() {
        int[] array = {1, 8, 10, 89, 1000, 1234};
        int index = mySearch(array, 10, 0, array.length);
        System.out.println(index);
    }

    /**
     * 如果数组内有多个相同元素，如何全部查找到
     */
    private static int mySearch2(int[] arr, int value, int left, int right) {
        int curLeft = left; //当前查找范围的左边界
        int curRight = right;   //当前查找范围的右边界
        int mid = (curLeft + curRight) / 2;
        //** 此处不可用=号，因为存在value==arr[left]的可能性
        //设置递归头
        if (left > right) {
            return -1;
        }

        if (value < arr[mid]) {
            //向左递归
            return mySearch2(arr, value, left, mid - 1);
        } else if (value > arr[mid]) {
            //向右递归
            return mySearch2(arr, value, mid + 1, right);
        } else {
            list.add(mid);
            for (int i = mid + 1; arr[i] == arr[mid]; i++) {
                list.add(i);
            }
            for (int i = mid - 1; arr[i] == arr[mid]; i--) {
                list.add(i);
            }
            return mid;
        }
    }

    /**
     * 测试二分查找改进方法
     */
    @Test
    public void test2() {
        int[] array = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        mySearch2(array, 1000, 0, array.length);
        System.out.println(list.toString());
    }

    /**
     * 网课demo
     * 如果数组内有多个相同元素，如何全部查找到
     */
    private static List<Integer> search2(int[] arr, int value, int left, int right) {
        int curLeft = left; //当前查找范围的左边界
        int curRight = right;   //当前查找范围的右边界
        int mid = (curLeft + curRight) / 2;
        //** 此处不可用=号，因为存在value==arr[left]的可能性
        //设置递归头
        if (left > right) {
            return new ArrayList<>();
        }

        if (value < arr[mid]) {
            //向左递归
            return search2(arr, value, left, mid - 1);
        } else if (value > arr[mid]) {
            //向右递归
            return search2(arr, value, mid + 1, right);
        } else {
            //*** else中的代码只在最底层执行了一次，然后一直向上返回到最高层
            List<Integer> indexList = new ArrayList<>();
            indexList.add(mid);
            //向右查找
            for (int i = mid + 1; arr[i] == arr[mid]; i++) {
                indexList.add(i);
            }
            //向左查找
            for (int i = mid - 1; arr[i] == arr[mid]; i--) {
                indexList.add(i);
            }
            return indexList;
        }
    }

    /**
     * 网课demo
     * 测试二分查找改进方法
     */
    @Test
    public void test3() {
        int[] array = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        List<Integer> indexList = search2(array, 1000, 0, array.length);
        System.out.println(indexList.toString());
    }
}
