package common_Algorithm.more.horse;

/**
 * 深信服机试编程第二题
 */
public class Q1 {
    //棋盘大小
    static int X = 4;
    static int Y = 4;
    //定义棋盘
    static int[][] CB;
    //定义移动增量（上下左右）
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //共有num种解
    static int num = 0;
    //计步器
    static int count = 0;

    static {
        //初始化棋盘
        CB = new int[X + 2][Y + 2];
        for (int row = 0; row < X + 2; row++) {
            //第一行和最后一行所有元素置-1
            if (row == 0 || row == X + 1) {
                for (int column = 0; column < Y + 2; column++) {
                    CB[row][column] = -1;
                }
            } else {
                //其他行第1列和最后1列元素置-1；其余元素置0
                for (int column = 0; column < Y + 2; column++) {
                    if (column == 0 || column == Y + 1) {
                        CB[row][column] = -1;
                    }
                }
            }
        }
    }

    /**
     * 打印解法
     */
    static void print() {
        System.out.printf("第%d种解：\n", ++num);
        //打印棋盘
        for (int i = 1; i <= X; i++) {
            for (int j = 1; j <= Y; j++) {
                System.out.printf("%3d", CB[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("**************************\n");
    }


    /**
     * 出发点为 x,y。离开点为 xOut,yOut
     *
     * @param x
     * @param y
     */
    static void check(int x, int y, int xOut, int yOut) {
        CB[x][y] = ++count;   //标记出发点
        if (count == X * Y && x == xOut && y == yOut) {
            print();
        } else {
            int xNext;
            int yNext;
            //遍历下一步所有可能的位置
            for (int i = 0; i < 4; i++) {
                xNext = move[i][0] + x;
                yNext = move[i][1] + y;
                //如果下一个位置 1.没有被走过    2.不是墙
                if (CB[xNext][yNext] == 0) {
                    //向下递归求解
                    check(xNext, yNext, xOut, yOut);
                    //回溯结束后重置该位置状态，以便进行下一解法的求解
                    CB[xNext][yNext] = 0;
                    --count;
                }
            }
        }
    }

    public static void main(String[] args) {
        check(1, 1, 2, 3);
    }
}
