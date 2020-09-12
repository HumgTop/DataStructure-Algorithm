package common_Algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 马踏棋盘算法（骑士周游问题）
 * 只能求出一种解法
 */
public class No10_HorseChessBoard {
    private static int X;   //棋盘的列数
    private static int Y;   //棋盘的行数
    private static boolean[] visited; //标记各个位置是否被访问过，长度为 X*Y
    private static boolean finished = false;    //如果为true，表示棋盘上所有位置均已被访问

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessBoard = new int[X][Y];
        visited = new boolean[X * Y];

        long start = System.currentTimeMillis();
        traverSalChessboard(chessBoard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("运行时间:" + (end - start));

        for (int[] rows : chessBoard) {
            for (int value : rows) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }

    /**
     * 核心方法
     *
     * @param chessBoard 棋盘矩阵
     * @param row
     * @param column
     * @param step       当前走到第几步
     */
    public static void traverSalChessboard(int[][] chessBoard, int row, int column, int step) {
        if (step == 64) {
            System.out.println("找出一个解");
        }
        chessBoard[row][column] = step; //将步数写在棋盘上
        visited[row * X + column] = true;   //假定此点可以走通，先标记为已经被访问
        Point curPoint = new Point(column, row);
        //获取下一步能走的位置
        ArrayList<Point> next = next(curPoint);
        sort(next);
        while (!next.isEmpty()) {
            Point nextPossible = next.remove(0);
            int visitedIndex = nextPossible.y * X + nextPossible.x;
            //如果该点未被访问过
            if (!visited[visitedIndex]) {
                //递归访问该点
                traverSalChessboard(chessBoard, nextPossible.y, nextPossible.x, step + 1);
            }
        }
        //如果棋盘未走完:说明此路不通
        //step < X*Y 有2种情况，一是棋盘到目前位置没有走完，二是棋盘处于回溯过程
        if (step < X * Y && !finished) {
            chessBoard[row][column] = 0;
            visited[row * X + column] = false;
        } else
            finished = true;
    }

    /**
     * 根据当前位置：curPoint对象，计算马儿下一步可能的位置，存入到list集合中（最多有8个）
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point point = new Point();
        //如果左上1号位置再棋盘范围内
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < Y) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < Y) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y + 2) < Y) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y + 1) < Y) {
            points.add(new Point(point));
        }
        //对集合中point进行排序（每个point的next集合大小进行升序排列）
        return points;
    }

    /**
     * 对points集合排序（贪心优化）
     * 每一步选择最优策略（尽可能少回溯）
     *
     * @param points
     */
    public static void sort(List<Point> points) {
        points.sort((o1, o2) ->
                //按next集合大小升序排列
                next(o1).size() - next(o2).size());
    }
}
