package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class B_HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] temp = new int[]{1, 2, 3};
        list.add(temp);
        temp = new int[]{4, 5, 6};
        for (int val : list.get(0)) {
            System.out.println(val);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target <= 2) return new int[][]{};

            //双指针i,j。和大了i右移一位，小了j右移一位
            int i = 1, j = 2;
            int sum = 3;    //窗口内的和
            List<int[]> res = new ArrayList<>();

            int[] temp;
            while (j < target) {
                if (sum < target) {
                    j++;
                    sum += j;
                } else if (sum > target) {
                    if (i < j - 1) {
                        sum -= i;
                        i++;
                    } else break;
                } else {
                    //sum==target
                    temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        temp[k - i] = k;
                    }
                    res.add(temp);
                    j++;
                    sum += j;
                }
            }

            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}