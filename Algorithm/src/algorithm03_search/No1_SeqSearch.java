package algorithm03_search;

/**
 * 线性查找方法
 */
public class No1_SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        System.out.println(seqSearch(arr, 34));
    }

    /**
     * 线性查找
     * @param arr
     * @param value
     * @return
     */
    private static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        throw new RuntimeException("所查找数组中不存在该元素");
    }
}
