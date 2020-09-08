package common_Algorithm;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法
 * 求解最小生成树
 */
public class No07_Kruskal_Algorithm {
    //使用INF表示2个顶点不能连通
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}
        };
        Graph graph = new Graph(vertexes, matrix);

        graph.kruskal();
    }
}

/**
 * 实例对象表示一个加权无向连通图
 */
class Graph {
    private int edgeNum;    //边的个数
    private char[] vertexes;    //顶点数组
    private int[][] matrix; //邻接矩阵
    //使用INF表示2个顶点不能连通
    public static final int INF = Integer.MAX_VALUE;

    public Graph(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;
        //初始化edgeNum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != INF) {
                    this.edgeNum++;
                }
            }
        }
    }

    /**
     * 打印邻接矩阵
     */
    public void print() {
        for (int[] rows : matrix) {
            for (int value : rows) {
                System.out.printf("%12d\t", value);
            }
            System.out.println();
        }
    }

    /**
     * 对图的所有边进行排序处理
     */
    private void sortEdges(EData[] edges) {
        //插入排序
        for (int i = 1; i < edges.length; i++) {
            int index;
            EData insertVal = edges[i];
            for (index = i - 1; index >= 0 && insertVal.weight < edges[index].weight; index--) {
                edges[index + 1] = edges[index];
            }
            //index=-1或者insertVal.weight>edges[index].weight
            edges[index + 1] = insertVal;
        }
    }

    /**
     * 获取顶点在数组中的索引
     *
     * @param vertex
     * @return
     */
    private int getIndex(char vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertex == vertexes[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 创建图中所有边的集合
     *
     * @return 边的数组
     */
    public EData[] createEdges() {
        EData[] eData = new EData[edgeNum];
        int index = 0;
        //遍历邻接矩阵
        int[][] temp = Arrays.copyOf(matrix, matrix.length);
        for (int i = 0; i < temp.length; i++) {
            //只遍历邻接矩阵的右上半部分
            for (int j = i + 1; j < temp[i].length; j++) {
                int curWeight = temp[i][j];
                //如果是连通的
                if (curWeight != INF) {
                    //添加EData对象到集合中
                    char start = vertexes[i];
                    char end = vertexes[j];
                    eData[index++] = new EData(start, end, curWeight);
                }
            }
        }
        sortEdges(eData);   //将eData中的元素按权值从小到大排序
        return eData;
    }

    /**
     * 获取下标为i的顶点的终点
     *
     * @param ends
     * @param i
     * @return
     */
    public int getEnd(int[] ends, int i) {
        //如果ends[i]不等于0，说明还未找到终点，更新i继续寻找终点，直到ends[i]==0
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    /**
     * 克鲁斯卡尔算法（求解加权连通无向图的最小生成树）
     */
    public void kruskal() {
        int index = 0;
        //用于保存“已有最小生成树”中每个顶点在最小生成树中的终点
        int[] ends = new int[edgeNum];
        //创建结果数组，保存最后的最小生成树
        EData[] minTree = new EData[vertexes.length - 1];
        EData[] allEdges = createEdges();   //长度为12
        //对所有边按权值排序
        sortEdges(allEdges);
        //按照不构成回路的原则，按权值大小添加边到minTree中
        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的的start和end，判断是否有相同的终点
            int startIndex = getIndex(allEdges[i].start);
            int endIndex = getIndex(allEdges[i].end);
            int m = getEnd(ends, startIndex);
            int n = getEnd(ends, endIndex);
            //如果终点不同，说明不构成回路，将边添加到minTree中
            if (m != n) {
                minTree[index++] = allEdges[i];
                //设置顶点m在最小生成树的终点
                ends[m] = n;
            }
        }
        System.out.println(Arrays.toString(minTree));
    }
}

/**
 * 实例对象表示一条边
 */
class EData {
    char start;
    char end;
    int weight; //边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" + start +
                "," + end +
                ">, weight=" + weight +
                '\n';
    }
}
