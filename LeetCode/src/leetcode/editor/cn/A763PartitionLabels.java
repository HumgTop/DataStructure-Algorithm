package leetcode.editor.cn;
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 276 👎 0

import java.util.ArrayList;
import java.util.List;

public class A763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new A763PartitionLabels().new Solution();
        System.out.println('a' - 97);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String S) {
            //遍历S，用last数组记录其中每个字符最后出现的位置
            int[] last = new int[26];

            for (int i = 0; i < S.length(); i++) {
                last[S.charAt(i) - 'a'] = i;    //记录该字母最后出现的位置
            }

            int begin = 0, end = 0;
            List<Integer> res = new ArrayList<>();

            int index;
            for (int i = 0; i < S.length(); i++) {
                index = S.charAt(i) - 'a';  //当前字符在last中对应的索引
                end = Math.max(end, last[index]);   //不断更新遍历到目前为止，字符出现的最后的位置
                if (i == end) {
                    res.add(i - begin + 1);
                    begin = i + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}