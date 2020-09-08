package common_Algorithm;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法
 * 求解最短路径问题
 */
public class No08_Dijkstra_Algorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;    // 表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        //创建 Graph 对象
        Dgraph graph = new Dgraph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否 ok
        graph.showGraph();

        graph.dijkstra(2);
        graph.show();
    }
}

/**
 * 实例对象为一张图
 */
class Dgraph {
    private char[] vertex;  //顶点数组
    private int[][] matrix; //邻接矩阵
    private VisitedVertex visitedVertex;

    public Dgraph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    /**
     * @param index 出发顶点的下标
     */
    public void dijkstra(int index) {
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);  //更新顶点index到周围顶点的距离和前驱顶点
        for (int i = 1; i < vertex.length; i++) {
            index = visitedVertex.updateArr();  //更新下个访问节点
            update(index);
        }
    }

    /**
     * 更新顶点index到周围顶点的距离，以及周围顶点的前驱顶点
     *
     * @param index
     */
    private void update(int index) {
        int len;
        for (int i = 0; i < matrix[index].length; i++) {
            //更新dis数组，在原有距离的基础上累加
            len = visitedVertex.getDis(index) + matrix[index][i];
            //如果顶点i没有被访问过，且提供了更短的路径策略，则更新dis数组
            if (!visitedVertex.in(i) && len < visitedVertex.getDis(i)) {
                visitedVertex.updatePre(i, index);  //更新顶点i的前驱为顶点index
                visitedVertex.updateDis(i, len);    //更新出发顶点为顶点i
            }
        }
    }

    public void showGraph() {
        for (int[] rows : matrix) {
            for (int edge : rows) {
                System.out.printf("%10d", edge);
            }
            System.out.println();
        }
    }

    /**
     * 显示结果
     */
    public void show() {
        System.out.println("出发点到其他顶点的最短距离：" + Arrays.toString(visitedVertex.dis));
        System.out.println("顶点i的前驱顶点为pre[i]：" + Arrays.toString(visitedVertex.pre_visited));
    }
}

/**
 * 实例对象为一个被访问顶点集合
 */
class VisitedVertex {
    //记录节点i是否被访问过，如访问 already_arr[i]=1
    public int[] already_arr;
    //pre_visited[i]为当前节点i的前驱节点下标
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离，会动态更新
    public int[] dis;

    /**
     * @param length 表示顶点的个数
     * @param index  出发顶点的下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;
        this.dis[index] = 0;
    }

    /**
     * 判断顶点index是否被访问过
     *
     * @param index
     * @return
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到顶点index的距离
     *
     * @param index
     * @param length
     */
    public void updateDis(int index, int length) {
        dis[index] = length;
    }

    /**
     * 更新顶点pre的前驱节点为index
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到顶点index的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点
     *
     * @return
     */
    public int updateArr() {
        int min = 65535;
        int index = 0;
        //找到当前dis数组中未访问过的最小值对应的顶点下标
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }
}