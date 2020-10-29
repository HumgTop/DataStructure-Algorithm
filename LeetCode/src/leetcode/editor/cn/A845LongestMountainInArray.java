package leetcode.editor.cn;
//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 91 👎 0

import javax.sound.midi.Track;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A845LongestMountainInArray {
    public static void main(String[] args) {
        Solution solution = new A845LongestMountainInArray().new Solution();
        int[] a = {0, 2, 2};
        System.out.println(solution.longestMountain(a));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestMountain(int[] A) {
            if (A.length < 3) return 0;
            int maxLen = 0;
            int tempLen = 0;

            boolean rise = false; //记录上一次状态是上升还是下降

            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] == A[i]) { //非法，重置状态
                    tempLen = 0;
                    rise = false;
                } else if (A[i] > A[i - 1]) {
                    if (rise) { //如果为上升状态
                        tempLen++;
                    } else {    //如果上一次为下降，重新记录长度
                        rise = true;
                        tempLen = 2;
                    }
                } else if (tempLen > 0) {   //当前为下降状态
                    tempLen++;
                    rise = false;   //更新状态
                    maxLen = Math.max(tempLen, maxLen);
                }
            }

            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}