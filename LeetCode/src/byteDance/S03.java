package byteDance;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Autor HumgTop
 * @Date 2021/9/3 20:28
 * @Version 1.0
 * 求区间最小数乘区间和的最大值
 */
public class S03 {
    @Test
    public void test() {
        System.out.println(solution(new int[]{1, 5, 6, 3, 9}));     //输出81
    }

    int solution(int[] arr) {
        int n = arr.length;
        int[] preSum = new int[n + 1];

        //初始化前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peekLast()]) {
                int peakIdx = stack.removeLast();   //区间最小值
                int l = stack.isEmpty() ? -1 : stack.peekLast();
                int r = i;
                //l和r是边界，因此区间是[l+1,r-1]，其区间和为preSum[r]-dp[l+1]
                int intervalSum = preSum[r] - preSum[l + 1];
                res = Math.max(res, intervalSum * arr[peakIdx]);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int peakIdx = stack.removeLast();   //arr[peakIdx]为区间[l+1,n-1]的最小值
            int l = stack.isEmpty() ? -1 : stack.peekLast();
            int r = n;
            int intervalSum = preSum[r] - preSum[l + 1];
            res = Math.max(res, intervalSum * arr[peakIdx]);
        }

        return res;
    }
}
