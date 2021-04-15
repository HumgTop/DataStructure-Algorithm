package leetcode.editor.cn;


import java.util.PriorityQueue;

public class B_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) return new int[]{};
            //topK问题
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            int idx = 0;
            //初始化堆
            while (maxHeap.size() < k) {
                maxHeap.add(arr[idx++]);
            }

            while (idx < arr.length) {
                if (arr[idx] < maxHeap.peek()) {
                    maxHeap.remove();
                    maxHeap.add(arr[idx]);
                }
                idx++;
            }

            int[] res = new int[k];
            for (int i = 0; i < res.length; i++) {
                res[i] = maxHeap.remove();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}