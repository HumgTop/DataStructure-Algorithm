from typing import *


# 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
# 句子。 
# 
#  说明： 
# 
#  
#  分隔时可以重复使用字典中的单词。 
#  你可以假设字典中没有重复的单词。 
#  
# 
#  示例 1： 
# 
#  输入:
# s = "catsanddog"
# wordDict = ["cat", "cats", "and", "sand", "dog"]
# 输出:
# [
#   "cats and dog",
#   "cat sand dog"
# ]
#  
# 
#  示例 2： 
# 
#  输入:
# s = "pineapplepenapple"
# wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
# 输出:
# [
#   "pine apple pen apple",
#   "pineapple pen apple",
#   "pine applepen apple"
# ]
# 解释: 注意你可以重复使用字典中的单词。
#  
# 
#  示例 3： 
# 
#  输入:
# s = "catsandog"
# wordDict = ["cats", "dog", "sand", "and", "cat"]
# 输出:
# []
#  
#  Related Topics 动态规划 回溯算法 
#  👍 278 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        wordSet = set(wordDict)

        def recur(index: int) -> List[List[str]]:
            # 终止条件
            if index == len(s): return [[]]
            res = []  # 存放句子组合
            # 从index+1到子串末尾截取子串进行匹配
            for i in range(index + 1, len(s) + 1):
                word = s[index:i]
                if word in wordSet:
                    nextWordBreaks = recur(i)
                    for nextWordBreak in nextWordBreaks:
                        # 回溯阶段依次将本层的单词，合并到下层的句子组合后，并添加到res中
                        res.append(nextWordBreak.copy() + [word])

            return res

        breakList = recur(0)
        return [' '.join(words[::-1]) for words in breakList]

        # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
