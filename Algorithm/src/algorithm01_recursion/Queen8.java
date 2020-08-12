package algorithm01_recursion;

/**
 * 八皇后问题（回溯算法）
 */
public class Queen8 {
    private static int max = 8;  //表示共有8个皇后
    private static int[] arr = new int[max]; //用一维数组定义棋盘。数组下标表示皇后所在行，数组值表示所在列
    private static short count = 0; //对print方法执行次数进行计数
    private static short judgeCount = 0; //对judge方法执行次数进行计数

    public static void main(String[] args) {
        check(0);   //将第1到8个皇后放置在棋盘上
        System.out.printf("judge方法的执行次数是%d次%n", judgeCount);
    }

    /**
     * 在控制台输出皇后的摆放位置
     */
    private static void print() {
        count++;
        System.out.printf("第%d种解法%n", count);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d行%d列\t", i + 1, arr[i] + 1);
        }
        System.out.println();
        System.out.println("--------------");
    }

    /**
     * 判断已经放置的皇后中是否违反摆放规则（已经放置到第n个皇后，检测与之前n-1个皇后是否有位置冲突）
     * 规则：任意2个皇后不能在同一行、列或者斜线上
     *
     * @param n n从0开始
     * @return
     */
    private static boolean judge(int n) {
        judgeCount++;
        //遍历与之前摆放的皇后进行比较判断
        for (int i = 0; i < n; i++) {
            //因为i<n所以肯定不在同一行，只需判断是否在同一列或者斜线上即可
            //如果两皇后所在行数的差等于所在列数的差（绝对值），说明在同一斜线上（正反斜线）
            if (arr[i] == arr[n] || (n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将第n+1到第8个皇后放置到棋盘上
     *
     * @param n n从0开始
     */
    public static void check(int n) {
        //递归头：如果8个皇后已经全部放好
        if (n == max) {
            print();    //打印棋盘
            return;
        }
        //在judge方法返回true的情况下，依次放置皇后
        for (int i = 0; i < max; i++) {
            //将皇后n放置在所有可能的位置，使用judge方法判断，只要不冲突，就递归调用check放置下一个皇后
            arr[n] = i;
            //递归体：什么情况下进行递归
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
}
