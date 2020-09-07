package common_Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 普里姆算法
 * 求解最小生成树
 */
public class No06_Prim_Algorithm {
    static MGraph graph;    //加权无向连通图

    public static void showGraph() {
        for (int[] rows : graph.weight) {
            System.out.println(Arrays.toString(rows));
        }
    }

    /**
     * 使用普里姆算法得到最小生成树
     * 设 G=(V,E)是连通网， T=(U,D)是最小生成树， V,U 是顶点集合， E,D 是边的集合
     */
    public static String myPrim() {
        int[] isVisited = new int[graph.vertexNum];
        StringBuilder D = new StringBuilder();
        ArrayList<Integer> U = new ArrayList<>();
        //全部顶点的集合
        ArrayList<Character> V = new ArrayList<>(Arrays.asList(graph.data));
        U.add(0);
        isVisited[0] = 1;
        for (int i = 1; i < graph.vertexNum; i++) {
            int minWeight = 0;
            int uIndex = 0;
            int vIndex = 0;
            boolean flag = false;
            //若顶点uj与V集合中剩余的顶点vk存在连通关系，将权值最小的边加入D集合中，vk加入U集合中，
            for (int j = 0; j < U.size(); j++) {
                for (int k = 0; k < V.size(); k++) {
                    if (isVisited[k] == 1) {
                        continue;
                    }
                    int curWeight = graph.weight[U.get(j)][k];    //此处应拿到G-B之间的权值，实际拿的是B-B之间的权值
                    //保证至少赋值一次
                    if (!flag && curWeight != 10000) {
                        minWeight = curWeight;
                        uIndex = j;
                        vIndex = k;
                        flag = true;
                    }
                    if (curWeight != 10000 && curWeight < minWeight) {
                        //找到更优点，进行更新
                        minWeight = curWeight;
                        uIndex = j;
                        vIndex = k;
                    }
                }
            }
            U.add(vIndex);
            isVisited[vIndex] = 1;
            D.append(U.get(uIndex) + "," + vIndex + "\t");
        }
        System.out.println(U);
        return D.toString();
    }

    /**
     * 网课demo
     * 普里姆算法
     * 设 G=(V,E)是连通网， T=(U,D)是最小生成树， V,U 是顶点集合， E,D 是边的集合
     */
    public void prim(int index) {
        int[] isVisited = new int[graph.vertexNum]; //标记是否被访问过
        isVisited[index] = 1;
        //记录2个顶点的下标
        int uIndex = -1;
        int vIndex = -1;
        int minWeight = 10000;    //先初始化minWeight

        //共需添加 vertexNum-1 条边到D集合中
        for (int k = 1; k < graph.vertexNum; k++) {
            //遍历U集合（即V集合中已被访问过的节点）
            for (int i = 0; i < graph.vertexNum; i++) {
                //遍历V集合中未访问过的元素，找出边权值最小的ui和vj（此边添加到D集合，构成最小生成树）
                for (int j = 0; j < graph.vertexNum; j++) {
                    int curWeight = graph.weight[i][j]; //当前ui和vj间的权值
                    if (isVisited[i] == 1 && isVisited[j] == 0 && curWeight < minWeight) {
                        minWeight = curWeight;
                        //记录下标是为了记录构成最小生成树的边
                        uIndex = i;
                        vIndex = j;
                    }
                }
            }
            System.out.printf("边<%s,%s>，权值：%d\n", graph.data[uIndex], graph.data[vIndex], minWeight);
            isVisited[vIndex] = 1;  //将V集合中添加的顶点标记为1
            minWeight = 10000;    //重置minWeight
        }
    }

    @Test
    public void primTest() {
        //共有7个顶点
        Character[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexNum = 7;
        //邻接矩阵（描述7个顶点间的连通关系）
        //10000表示没有连通（权值很大，就不会选择这条路）
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        graph = new MGraph(vertexNum, data, weight);

        prim(0);
    }

    public static void main(String[] args) {
        //共有7个顶点
        Character[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexNum = 7;
        //邻接矩阵（描述7个顶点间的连通关系）
        //10000表示没有连通（权值很大，就不会选择这条路）
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        graph = new MGraph(vertexNum, data, weight);

        System.out.println(myPrim());
    }
}

class MGraph {
    int vertexNum;  //表示存放节点的个数
    Character[] data;    //存放节点的数据
    int[][] weight; //邻接矩阵的权值

    public MGraph(int vertexNum, Character[] data, int[][] weight) {
        this.vertexNum = vertexNum;
        this.data = data;
        this.weight = weight;
    }
}