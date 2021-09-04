package byteDance;

/**
 * @Autor HumgTop
 * @Date 2021/9/2 9:57
 * @Version 1.0
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 */
public class S01 {
    public static void main(String[] args) {
        //dp[i][j]表示从0点出发走i步，到j点的方案数
        int len = 10;
        System.out.println(solution(2, 10));
    }

    private static int solution(int n, int len) {
        int[][] dp = new int[n + 1][len];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + len) % len] + dp[i - 1][(j + 1) % len];
            }
        }

        return dp[n][0];
    }
}
