package leetcode.editor.cn;

public class A424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new A424_LongestRepeatingCharacterReplacement().new Solution();
        System.out.println(solution.characterReplacement("BAAA", 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int maxsame = 0;    //当前窗口中，最长的相同元素子串
            int[] frep = new int[26];   //记录窗口内不同字母出现的频次
            int len = s.length();
            int left = 0, right = 0;

            while (right < len) {
                int cur = (int) s.charAt(right) - 'A';  //当前字母的ASCII码相对值
                frep[cur]++;
                maxsame = Math.max(maxsame, frep[cur]); //判断maxsame是否需要更新
                if (maxsame + k < right - left + 1) {   //说明此时k不够用，窗口左边界移动
                    frep[(int) s.charAt(left) - 'A']--;
                    left++;
                }
                right++;
            }

            return right - left;    //因为最后right++，所以窗口长度为right-left而不是right-left+1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}