package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 矩阵的环形打印
 */
public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<int[]> indexList = new ArrayList<>();
        if (matrix == null)
            return list;
        int start = 0;
        int count = 0;
        //定义每圈的起始位置为(start,start)
        while (matrix[0].length > start * 2 && matrix.length > start * 2) {
            int[] index = new int[2];
            int endX = matrix[0].length - 1 - start;  //列
            int endY = matrix.length - 1 - start;  //行
            //从左往右
            for (int i = start; i <= endX; i++) {
                list.add(matrix[start][i]);
                count++;
                if (count > 10) {
                    String countStr = String.valueOf(count);
                    int length = countStr.length();
                    int shiWeiNum = count / (10 * (length - 1)) % 10;

                    if (countStr.charAt(length - 1) == '7' && shiWeiNum % 2 != 0) {
                        index[0] = start;
                        index[1] = i;
                        indexList.add(index);    //添加特战队员坐标
                        System.out.println(count);
                    }
                }
            }
            //从上往下
            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) {
                    list.add(matrix[i][endY]);
                    count++;
                    if (count > 10) {
                        String countStr = String.valueOf(count);
                        int length = countStr.length();
                        int shiWeiNum = count / (10 * (length - 1)) % 10;

                        if (countStr.charAt(length - 1) == '7' && shiWeiNum % 2 != 0) {
                            index[0] = i;
                            index[1] = endY;
                            indexList.add(index);    //添加特战队员坐标
                            System.out.println(count);
                        }
                    }
                }
            }
            // 从右往左（判断是否会重复打印）
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; i--) {
                    list.add(matrix[endY][i]);
                    count++;
                    if (count > 10) {
                        String countStr = String.valueOf(count);
                        int length = countStr.length();
                        int shiWeiNum = count / (10 * (length - 1)) % 10;

                        if (countStr.charAt(length - 1) == '7' && shiWeiNum % 2 != 0) {
                            index[0] = endY;
                            index[1] = i;
                            indexList.add(index);    //添加特战队员坐标
                            System.out.println(count);
                        }
                    }
                }
            }
            // 从下往上（判断是否会重复打印）
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i >= start + 1; i--) {
                    list.add(matrix[i][start]);
                    count++;
                    if (count > 10) {
                        String countStr = String.valueOf(count);
                        int length = countStr.length();
                        int shiWeiNum = count / (10 * (length - 1)) % 10;

                        if (countStr.charAt(length - 1) == '7' && shiWeiNum % 2 != 0) {
                            index[0] = i;
                            index[1] = start;
                            indexList.add(index);    //添加特战队员坐标
                            System.out.println(count);
                        }
                    }
                }
            }
            start++;
        }
        System.out.println("-------------");
        System.out.println(count);
        System.out.println("-------------");
        for (int[] each : indexList) {
            System.out.println(Arrays.toString(each));
        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = new int[10][10];
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list.toString());
    }
}
