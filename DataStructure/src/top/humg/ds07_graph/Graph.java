package top.humg.ds07_graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<String> vertexList;   //存储顶点集合
    int[][] edges;  //存储图对应的邻接矩阵
    int numOfEdges = 0;   //表示边的数目
    boolean[] isVisited;    //标记数组：标记节点的访问状态

    public Graph() {
    }

    /**
     * @param n 顶点数
     */
//    public Graph(int n) {
//        //初始化矩阵和vertexList
//        edges = new int[n][n];
//        vertexList = new ArrayList<>(n);
//        isVisited = new boolean[n];
//    }

    /**
     * 插入顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 设置edges矩阵：表明v1和v2的连接关系
     *
     * @param v1
     * @param v2
     * @param weight 0为不连通，1为连通
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 得到第一个邻接节点的下标
     *
     * @return
     */
//    public int getFirstNeighbor(int index) {
//        //遍历邻接矩阵中的第index行，寻找邻接节点
//        for (int i = 0; i < vertexList.size(); i++) {
//            if (edges[index][i] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }

    /**
     * 寻找前一个邻接节点之后的下一个邻接节点
     *
     * @param v1：如果v1=-1，说明查找当前节点的第一个邻接节点
     * @param cur
     * @return
     */
    public int getNextNeighbor(int cur, int v1) {
        for (int i = v1 + 1; i < vertexList.size(); i++) {
            if (edges[cur][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获得当前节点的第一个邻接节点
     *
     * @param cur
     * @return
     */
    public int getNextNeighbor(int cur) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[cur][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回节点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到当前边的数目
     *
     * @return
     */
    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    /**
     * 通过索引获得顶点集合中对应的元素
     *
     * @param index
     * @return
     */
    public String getValByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 获得v1和v2之间的权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 打印邻接矩阵
     */
    public void printEdges() {
        for (int[] edge : edges) {
            for (int value : edge) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }

    /**
     * 单个节点的深度优先遍历算法
     *
     * @param isVisited
     * @param cur：当前被深度遍历的节点
     */
    public void depthFirstSearch(boolean[] isVisited, int cur) {
        //访问当前节点
        System.out.print(getValByIndex(cur) + "->");
        //更新访问状态
        isVisited[cur] = true;
        //查找当前节点的第一个邻接节点
        int neighborIndex = getNextNeighbor(cur);
        //如果cur有邻接节点的话
        while (neighborIndex != -1) {
            //且没有被访问过
            if (!isVisited[neighborIndex]) {
                //递归遍历
                depthFirstSearch(isVisited, neighborIndex);
            }
            //firstNeighbor后移指向当前节点的下一个邻接节点
            neighborIndex = getNextNeighbor(cur, neighborIndex);
        }
    }

    /**
     * 重载，遍历所有节点进行dfs
     * 存在一种情况：即有一个F节点，和ABCDE都无路径联系，此时需要这个方法才可遍历到 F
     */
    public void depthFirstSearch() {
        //每一次循环遍历出该节点所有可以到达的节点
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                depthFirstSearch(isVisited, i);
            }
        }
    }

    /**
     * dfs算法的测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        //初始化矩阵和vertexList
        int n = 5;
        graph.edges = new int[n][n];
        graph.vertexList = new ArrayList<>(n);
        graph.isVisited = new boolean[n];

        String[] vertexes = {"A", "B", "C", "D", "E"};
        graph.vertexList.addAll(Arrays.asList(vertexes));
        Queue<Integer> queue = new LinkedList<>();
        //添加节点A的路径关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        //添加B的路径关系（A-B已经添加，不重复添加）
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.printEdges();
        //因为A点都有连接关系（直接连接或间接连接）所以理论上一次dfs就可以遍历所有节点
//        graph.depthFirstSearch(graph.isVisited, 0);

        graph.depthFirstSearch();
    }

    /**
     * 广度优先搜索
     * 优先进行横向访问节点
     *
     * @param queue :存储还未进行向下纵向遍历的节点
     */
    public void myBroadFirstSearch(boolean[] isVisited, int cur, Queue<Integer> queue) {
        if (!isVisited[cur]) {
            System.out.print(getValByIndex(cur) + "->"); //先访问当前节点
            isVisited[cur] = true;    //标记为已访问
        }
        queue.add(cur); //加入队列中

        Integer head = queue.remove();
        int neighbor = getNextNeighbor(head);   //获得head的第一个邻接节点
        //当head层还有邻接节点时，持续遍历
        while (neighbor != -1) {
            //且没有被访问过
            if (!isVisited[neighbor]) {
                System.out.print(getValByIndex(neighbor) + "->");
                isVisited[neighbor] = true;
                queue.add(neighbor);
            }
            neighbor = getNextNeighbor(head, neighbor);
        }
        //如果队列中还有元素的话
        if (!queue.isEmpty()) {
            //本层结束递归进入下一层继续横向遍历
            Integer next = queue.remove();
            //*** 相当于对queue中的元素依次调用了一次bfs方法（因为各次递归之间没有依赖（如上层需要下层的返回值），所以可以比较容易改写为while循环
            myBroadFirstSearch(isVisited, next, queue);
        }
    }

    /**
     * 测试广度优先搜索
     */
    @Test
    public void testMyBFS() {
        Graph graph = new Graph();
        //初始化矩阵和vertexList
        int n = 5;
        graph.edges = new int[n][n];
        graph.vertexList = new ArrayList<>(n);
        graph.isVisited = new boolean[n];

        String[] vertexes = {"A", "B", "C", "D", "E"};
        graph.vertexList.addAll(Arrays.asList(vertexes));
        //存储还未进行向下纵向遍历的节点
        Queue<Integer> queue = new LinkedList<>();
        //添加节点A的路径关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        //添加B的路径关系（A-B已经添加，不重复添加）
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.printEdges();

        graph.myBroadFirstSearch(graph.isVisited, 0, queue);
    }

    /**
     * 广度优先搜索
     * 网课demo
     * 存在一种情况：即有一个F节点，和ABCDE都无路径联系，此时需要单独调用dfs方法去遍历 F
     *
     * @param isVisited
     * @param cur
     */
    public void bfs(boolean[] isVisited, int cur) {
        int head;   //当前遍历head层
        int neighbor;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValByIndex(cur) + "->");
        isVisited[cur] = true;
        //加入队列
        queue.addLast(cur);
        while (!queue.isEmpty()) {
            //更新head，进行下一轮横向遍历
            head = queue.removeFirst();
            //获得head的第一个邻接节点
            neighbor = getNextNeighbor(head);
            //如果有邻接点
            //持续遍历到head层再无邻接点
            while (neighbor != -1) {
                //且未访问过
                if (!isVisited[neighbor]) {
                    System.out.print(getValByIndex(neighbor) + "->");
                    isVisited[neighbor] = true;
                    queue.addLast(neighbor);
                }
                //neighbor指向head层的下一个邻接点
                neighbor = getNextNeighbor(head, neighbor);
            }
        }
    }

    /**
     * 测试 bfs算法
     * 网课demo
     */
    @Test
    public void testBFS() {
        Graph graph = new Graph();
        //初始化矩阵和vertexList
        int n = 5;
        graph.edges = new int[n][n];
        graph.vertexList = new ArrayList<>(n);
        graph.isVisited = new boolean[n];

        String[] vertexes = {"A", "B", "C", "D", "E"};
        graph.vertexList.addAll(Arrays.asList(vertexes));
        //添加节点A的路径关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        //添加B的路径关系（A-B已经添加，不重复添加）
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.printEdges();

        graph.bfs(graph.isVisited, 0);
    }

    @Test
    public void testBfsAndDfs() {
        Graph graph = new Graph();
        //初始化矩阵和vertexList
        int n = 8;
        graph.edges = new int[n][n];
        graph.vertexList = new ArrayList<>(n);
        graph.isVisited = new boolean[n];
        String[] vertexes = {"1", "2", "3", "4", "5", "6", "7", "8"};
        graph.vertexList.addAll(Arrays.asList(vertexes));

        //添加路径关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(5, 6, 1);

        graph.printEdges();

//        graph.bfs(graph.isVisited, 0);
        graph.depthFirstSearch();
//        graph.myBroadFirstSearch(graph.isVisited, 0, new LinkedList<>());
    }
}
