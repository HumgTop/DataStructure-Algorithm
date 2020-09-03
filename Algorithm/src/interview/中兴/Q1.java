package interview.中兴;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] eggs = solution(5, 3);
        System.out.println(Arrays.toString(eggs));
    }

    /**
     * @param n 表示恐龙蛋总数
     * @param k 表示要拿走的蛋
     */
    public static int[] solution(int n, int k) {
        int[] eggs = new int[n];
        int a = 1;
        int b = n - k + 1;
        for (int i = 0; i < k; i++) {
            eggs[i] = b++;
        }
        for (int i = k; i < n; i++) {
            eggs[i] = a++;
        }
        return eggs;
    }
}
