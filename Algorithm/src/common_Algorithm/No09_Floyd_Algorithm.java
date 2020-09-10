package common_Algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 弗洛伊德算法
 * 求解给定加权图中顶点的最短路径
 */
public class No09_Floyd_Algorithm {
    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        //创建 Graph 对象
        FGraph graph = new FGraph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}

/**
 * 给定的加权无向连通图
 */
class FGraph {
    private char[] vertexes;
    private int[][] dis;    //保存从个顶点出发到其他各个顶点的距离（不断优化更新）
    private int[][] pre;    //** 保存到达目标顶点的前驱顶点

    /**
     * @param length
     * @param matrix   初始邻接矩阵
     * @param vertexes
     */
    public FGraph(int length, int[][] matrix, char[] vertexes) {
        this.vertexes = vertexes;
        this.dis = matrix;
        this.pre = new int[length][length];
        //初始化前驱顶点（初始状态为自己本身）
        for (int i = 0; i < pre.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 打印pre矩阵和dis矩阵
     */
    public void show() {
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                System.out.print("       " + vertexes[pre[i][j]]);
            }
            System.out.println();
            for (int j = 0; j < dis[i].length; j++) {
                System.out.printf("%s到%s的最短路径为%d\t", vertexes[i], vertexes[j], dis[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * 弗洛伊德算法主方法
     */
    public void floyd() {
        int len;
        //遍历中间顶点
        for (int k = 0; k < vertexes.length; k++) {
            //遍历出发顶点
            for (int i = 0; i < vertexes.length; i++) {
                //遍历到达顶点
                for (int j = 0; j < vertexes.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        pre[i][j] = pre[k][j];    //** 目标顶点都为j，所以前驱顶点相同
                        //1.i-j；2.i-k-j；选择1，2两个路径中较短的那个
                        dis[i][j] = len;
                    }
                }
            }
        }
    }
}
