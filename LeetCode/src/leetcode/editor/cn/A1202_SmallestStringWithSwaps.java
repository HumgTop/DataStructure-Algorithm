package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class A1202_SmallestStringWithSwaps {
    public static void main(String[] args) {
        Solution solution = new A1202_SmallestStringWithSwaps().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //每  个连通分量按照字典顺序进行排列
    class Solution {
        Map<Integer, Integer> parent = new HashMap<>();

        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int n = s.length();   //节点数
            //建立并查集
            for (List<Integer> pair : pairs) {
                int root1 = find(pair.get(0));
                int root2 = find(pair.get(1));
                if (root1 != root2) merge(root1, root2);
            }

            //为每个连通分量的根节点建立优先队列
            HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                //优先队列默认升序排列字符
                //此处不能用parent.get(i)，因为并不是所有的节点都指向根节点
                map.computeIfAbsent(find(i), key -> new PriorityQueue<>()).add(s.charAt(i));
            }
            //重构s
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                //此处可以用parent.get(i)，是因为经过上一轮路径压缩，所有的节点都指向了根节点
                sb.append(map.get(parent.get(i)).remove());
            }
            return sb.toString();
        }

        //查找当前节点的根并返回
        int find(int idx) {
            if (!parent.containsKey(idx)) {
                parent.put(idx, idx); //初始化根节点
            }
            //路径压缩，将该节点从父节点直接指向根节点
            if (idx != parent.get(idx)) {
                parent.put(idx, find(parent.get(idx)));
            }
            return parent.get(idx);
        }

        void merge(int rootX, int rootY) {
            parent.put(rootX, rootY);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}