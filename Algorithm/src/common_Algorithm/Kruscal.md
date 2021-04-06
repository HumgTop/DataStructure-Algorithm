
![](https://nas.humg.top:5181/images/2021/04/04/image.png)

```java
    class Solution {
        int[] parents;

        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;
            parents = new int[rows * cols];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            BiFunction<Integer, Integer, Integer> getIdx = (r, c) -> r * cols + c;  //二维坐标一维化
            PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));   //边权值的最小堆
            //构造边权值的优先队列
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Integer curIdx = getIdx.apply(i, j);
                    //构建与右侧邻接点的边
                    if (j < cols - 1)
                        edges.add(new int[]{curIdx, curIdx + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                    //构建与下侧邻接点的边
                    if (i < rows - 1)
                        edges.add(new int[]{curIdx, curIdx + cols, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
            }

            //遍历最小堆，直到起点与终点联通
            Integer desIdx = getIdx.apply(rows - 1, cols - 1);
            int res = 0;
            while (!edges.isEmpty() && find(0) != find(desIdx)) {
                int[] edge = edges.remove();
                merge(edge[0], edge[1]);
                res = edge[2];
            }

            //联通完成后，加入的最后一条边的权值最大，决定了最小消耗
            return res;
        }

        /**
         * @param idx 子节点索引
         * @return 根节点索引
         */
        int find(int idx) {
            if (parents[idx] != idx)
                parents[idx] = find(parents[idx]);  //递归查找，重新设置idx的根节点（路径压缩）
            return parents[idx];
        }

        //对2个节点进行联通（已联通则跳过，未联通则进行联通）
        void merge(int idx1, int idx2) {
            int root1 = find(idx1);
            int root2 = find(idx2);
            if (root1 != root2)
                parents[root1] = root2; //可记录联通次数：即为最小生成树的边总数
        }
    }
```