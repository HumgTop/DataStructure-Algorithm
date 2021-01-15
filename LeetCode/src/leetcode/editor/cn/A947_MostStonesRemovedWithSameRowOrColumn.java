package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class A947_MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        Solution solution = new A947_MostStonesRemovedWithSameRowOrColumn().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 将二维坐标系降成一维
    class Solution {
        Map<Integer, Integer> parent = new HashMap<>(); //key为节点，value为根节点（代表一个连通分量）
        int count = 0;

        public int removeStones(int[][] stones) {
            int nodesCount = stones.length;
            for (int[] stone : stones) {
                int rootX = find(stone[0] + 10001);
                int rootY = find(stone[1]);
                if (rootX != rootY) merge(rootX, rootY);    //对于还没有合并的2个连通分量进行合并
            }
            return nodesCount - count;
        }

        //查找节点idx的根节点
        int find(int idx) {
            //初始化parent
            if (!parent.containsKey(idx)) {
                parent.put(idx, idx);
                count++;    //parent新加入一个节点，连通分量总数+1
            }
            //递归查找（路径压缩），最终更新idx的根节点
            if (idx != parent.get(idx)) parent.put(idx, find(parent.get(idx)));
            return parent.get(idx);
        }

        //将2个连通分量合并
        void merge(int parentX, int parentY) {
            parent.put(parentX, parentY);
            count--;    //连通分量总数-1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}