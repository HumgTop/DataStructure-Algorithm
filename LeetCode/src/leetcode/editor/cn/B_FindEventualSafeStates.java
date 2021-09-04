package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


public class B_FindEventualSafeStates {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        List<Integer> res = new ArrayList<>();
        int[] color;
        int white = 0, gray = 1, black = 2; //表示未访问，在栈中或者不安全状态，已访问且安全节点
        int[][] graph;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            Map<Integer, Set<Integer>> map = new HashMap<>();   //key为节点，value为该节点可到达的节点列表
            int n = graph.length;
            color = new int[n];
            this.graph = graph;


            for (int i = 0; i < graph.length; i++) {
                if (dfs(i)) res.add(i);
            }

            return res;
        }

        //判断该节点是否安全
        private boolean dfs(int nodeIdx) {
            if (color[nodeIdx] != white) {
                //如果颜色为gray表示在栈中或者不安全，返回false
                return color[nodeIdx] == black;
            }
            color[nodeIdx] = gray;
            //遍历后继节点
            for (int nextNodeIdx : graph[nodeIdx]) {
                //如果该节点安全则无需遍历
                if (color[nextNodeIdx] == black) continue;

                if (!dfs(nextNodeIdx)) return false;
            }
            //如果该节点所有的后继节点都是安全的，则该节点也是安全的
            color[nodeIdx] = black;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}