package leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 725 👎 0


import java.util.*;

public class A139WordBreak {
    public static void main(String[] args) {
        Solution solution = new A139WordBreak().new Solution();
        // TO TEST
        String[] word = {"apple", "pen"};
        List<String> strings = Arrays.asList(word);
        String s = "applepenapple";
        System.out.println(solution.wordBreak(s, strings));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> wordDict;

        public boolean wordBreak(String s, List<String> wordDict) {

            boolean[] dp = new boolean[s.length() + 1];     //dp[i]表示长度为i的子串能否被拆分

            for (String word : wordDict) {
                //初始化dp数组
                if (s.startsWith(word)) dp[word.length()] = true;
            }

            for (int i = 1; i < dp.length; i++) {
                //对能被拆分的子串（dp[i]为TRUE）进行状态转移
                if (dp[i]) {
                    //枚举所有可转移的状态
                    for (String word : wordDict) {
                        if (s.startsWith(word, i)) dp[i + word.length()] = true;
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}