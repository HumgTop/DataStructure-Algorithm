package common_Algorithm.more;

/**
 * 马踏棋盘算法的拓展
 * 求出所有解
 */
public class A1_Horse {
    //为了统一可移动方向的数目，给棋盘 外围加两圈
    static int R = 12;
    static int C = 12;
    static int[][] chessboard = new int[R][C];
    //移动增量数组
    static int[][] move = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    static int cnt = 0;    //步数计数器
    static int num = 0;    //解数计数器

    static void initialCB() {
        //初始化棋盘
        //遍历行
        for (int i = 0; i < R; i++) {
            //将上2行，下2行棋盘值置-1
            if (i == 0 || i == 1 || i == 10 || i == 11) {
                for (int j = 0; j < C; j++) {
                    chessboard[i][j] = -1;
                }
            } else {
                for (int j = 0; j < C; j++) {
                    //将其他行的前2列，后2列棋盘值置-1
                    if (j == 0 || j == 1 || j == 10 || j == 11) {
                        chessboard[i][j] = -1;
                    } else {
                        chessboard[i][j] = 0;
                    }
                }
            }
        }
    }

    static void print() {
        System.out.printf("第%d种解：\n", ++num);
        for (int i = 2; i < R - 2; i++) {
            for (int j = 2; j < C - 2; j++) {
                System.out.printf("%3d", chessboard[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("**************************\n");
    }

    static void horse(int x, int y) {
        chessboard[x][y] = ++cnt; //放置棋子
        if (cnt == 64) {
            //找到一组解，打印此种解法
            print();
        } else {
            int xNext, yNext;
            //遍历当前棋子的每一个可能的方向
            for (int i = 0; i < 8; i++) {
                xNext = x + move[i][0];
                yNext = y + move[i][1];
                //** 1.如果下一步的位置没有被走过 2.走到了棋盘外，棋盘值为-1
                if (chessboard[xNext][yNext] == 0) {
                    //向下递归继续走
                    horse(xNext, yNext);
                    //回溯结束后重置当前点状态（为进行求解下一个走法做准备）
                    chessboard[xNext][yNext] = 0;
                    --cnt;
                }
            }
        }
    }

    public static void main(String[] args) {
//        for (int i = 2; i < R - 2; i++) {
//            for (int j = 2; j < C - 2; j++) {
//                initialCB();
//                cnt = 0;
//                horse(i, j);
//            }
//        }
        initialCB();
        horse(2, 2);
        System.out.print("\n end\n");
    }
}
