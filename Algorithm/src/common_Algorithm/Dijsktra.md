迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个节点到其他节点的最短路径。它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止

### 基本思想

1. 通过Dijkstra计算图G中的最短路径时，需要指定起点s(即从顶点s开始计算)。

2. 此外，引进两个集合S和U。S的作用是记录已求出最短路径的顶点(以及相应的最短路径长度)，而U则是记录还未求出最短路径的顶点(以及该顶点到起点s的距离)。

3. 初始时，S中只有起点s；U中是除s之外的顶点，并且U中顶点的路径是”起点s到该顶点的路径”。然后，从U中找出路径最短的顶点，并将其加入到S中；接着，更新U中的顶点和顶点对应的路径。 然后，再从U中找出路径最短的顶点，并将其加入到S中；接着，更新U中的顶点和顶点对应的路径。 … 重复该操作，直到遍历完所有顶点。
```java
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;
            int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            boolean[][] visited = new boolean[rows][cols];  //标记该点是否已访问
            int[][] dist = new int[rows][cols]; //起点到该点的最小消耗值
            //初始化dist：默认值为最大整形
            for (int i = 0; i < dist.length; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            visited[0][0] = true;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));  //最小堆
            pq.add(new int[]{0, 0, 0});

            int res = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.remove();
                if (cur[0] == rows - 1 && cur[1] == cols - 1) {
                    //到终点的最短路径已确定，其余点无须再遍历
                    res = cur[2];
                    break;
                }
                //添加cur的未访问邻接点到队列
                for (int[] move : moves) {
                    int nr = cur[0] + move[0];
                    int nc = cur[1] + move[1];
                    //如果该点越界，或者到该点的最短路径已确定，则跳过
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc])
                        continue;
                    visited[cur[0]][cur[1]] = true;   //标记此点被访问
                    //优化(0,0)->(nr,nc)的最短路径：直达或者通过(cur[0],cur[1])中转
                    dist[nr][nc] = Math.min(dist[nr][nc], Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[nr][nc])));
                    pq.add(new int[]{nr, nc, dist[nr][nc]});    //将已确定最短路径的节点入列
                }
            }

            return res;
        }
    }
```