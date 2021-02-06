package leetcode.editor.cn;

import java.util.Arrays;

public class A1423_MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new A1423_MaximumPointsYouCanObtainFromCards().new Solution();
        int[] input = LeetCodeUtils.get1dArr("[2,3,4,100,1,5,200,1]");
        System.out.println(solution.maxScore(input, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int len = cardPoints.length;
            if (k == len) return Arrays.stream(cardPoints).sum();

            int left = 0, right = 0;
            int count = 0;  //  记录当前窗口内的元素个数
            int temp = Integer.MAX_VALUE;
            int curSum = 0;

            while (right < len) {
                while (count < len - k) {
                    curSum += cardPoints[right++];
                    count++;
                    if (count == len - k) temp = Math.min(temp, curSum);  //维护temp为窗口中和的最小值
                }
                curSum += cardPoints[right++];
                curSum -= cardPoints[left++];   //窗口向右移动（窗口长度恒定）
                temp = Math.min(temp, curSum);
            }

            return Arrays.stream(cardPoints).sum() - temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}