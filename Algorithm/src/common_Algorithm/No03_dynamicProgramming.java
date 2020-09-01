package common_Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划问题
 */
public class No03_dynamicProgramming {
    /**
     * 动态规划解决背包问题
     * 网课demo
     *
     * @param weight   第i个物品占用的容量为weight[i-1]
     * @param value    第i个物品的价值为 value[i-1]
     * @param capacity 背包的容量为 capacity
     */
    public void knapsackProblemSolution(int[] weight, int[] value, int capacity) {
        int num = weight.length;  //物品的数量
        //表示在前i个物品中能装入容量为capacity的背包中的最大价值
        int[][] maxValue = new int[num + 1][capacity + 1];
        //记录商品的放入情况
        int[][] path = new int[num + 1][capacity + 1];

        //从1开始操作二维表格 maxValue
        int lastSameCapacityMaxValue;   //目前为止背包容量的最大价值
        int curValue;   //当前价值（如果更优则存入）
        for (int i = 1; i < maxValue.length; i++) {
            for (int dynamicCapacity = 1; dynamicCapacity < maxValue[i].length; dynamicCapacity++) {
                lastSameCapacityMaxValue = maxValue[i - 1][dynamicCapacity];
                //如果需要放入的物品大于当前背包容量（没有放入的可能性），使用上一行同列单元格的策略
                if (weight[i - 1] > dynamicCapacity) {
                    maxValue[i][dynamicCapacity] = lastSameCapacityMaxValue;
                    continue;
                }
                //如果当前物品可以转入，比较当前策略和上次策略的优劣，择优
                curValue = value[i - 1] + maxValue[i - 1][dynamicCapacity - weight[i - 1]];
                if (curValue > lastSameCapacityMaxValue) {
                    maxValue[i][dynamicCapacity] = curValue;
                    path[i][dynamicCapacity] = 1; //策略更新（第i个商品放入一次），记为1
                } else {
                    maxValue[i][dynamicCapacity] = lastSameCapacityMaxValue;
                }
            }
        }

        //输出maxValue二维表格
        for (int[] rows : maxValue) {
            for (int each : rows) {
                System.out.printf("%d\t", each);
            }
            System.out.println();
        }
        System.out.println("-----------");

        //输出path二维表格
        for (int[] rows : path) {
            for (int each : rows) {
                System.out.printf("%d\t", each);
            }
            System.out.println();
        }
        System.out.println("-------------");

        //** 逆向遍历path
        for (int i = path.length - 1, j = path[0].length - 1; i > 0 && j > 0; i--) {
            //从矩阵最后一个元素由下往上遍历
            if (path[i][j] == 1) {
                //说明此物品被放置过
                System.out.printf("第%d个商品放入背包\n", i);
                //放入物品后，更新背包容量。更新容量后再去对应的背包容量列中寻找下一个放入的商品（被标记为1）
                j -= weight[i - 1];
            }
        }
    }

    @Test
    public void testKnapsackProblem() {
        int[] weight = {1, 4, 3};
        int[] value = {1500, 3000, 2000};
        int capacity = 5;

        knapsackProblemSolution(weight, value, capacity);

    }

    /**
     * 复习
     *
     * @param weight   第i个物品占用的容量为weight[i-1]
     * @param value    第i个物品的价值为 value[i-1]
     * @param capacity 背包的容量为 capacity
     */
    public void knapsackProblemReview(int[] weight, int[] value, int capacity) {
        int num;
        int[][] maxValue;
        int[][] path;
        int lastSameCapacityMaxVal;
        int curPossibleVal;
    }
}
