package leetcode.editor.cn;

import java.util.Arrays;

public class A_406QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new A_406QueueReconstructionByHeight().new Solution();
        // TO TEST
        int[][] input = LeetCodeUtils.get2dArr("[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]");
        for (int[] ints : solution.reconstructQueue(input)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            if (people.length == 0) return new int[0][0];

            //按k值升序排序，k值相同按h值升序
            Arrays.sort(people, ((p1, p2) -> {
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else return p1[1] - p2[1];
            }));

            int[][] res = new int[people.length][people[0].length];
            for (int i = 0; i < people.length; i++) {
                //将[people[i][1]:i]的元素后移一格
                for (int j = i; j > people[i][1]; j--) {
                    res[j] = res[j - 1];
                }
                //将people[i]插入到res中
                res[people[i][1]] = people[i];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}