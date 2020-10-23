from typing import *

# 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
# 
#  示例 1: 
# 
#  输入: "abcabcbb"
# 输出: 3 
# 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
#  
# 
#  示例 2: 
# 
#  输入: "bbbbb"
# 输出: 1
# 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
#  
# 
#  示例 3: 
# 
#  输入: "pwwkew"
# 输出: 3
# 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
#      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
#  
#  Related Topics 哈希表 双指针 字符串 Sliding Window 
#  👍 4495 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 滑动窗口
        dequeue = deque()
        maxLen = 0

        for ch in s:
            if ch not in dequeue:
                dequeue.append(ch)
            else:
                # 如果ch已经在队列中，判断此时是否是最长子串
                maxLen = max(maxLen, len(dequeue))
                # 将重复字符从左侧出列，再从右侧将ch入列
                while dequeue:
                    if ch == dequeue.popleft(): break
                dequeue.append(ch)

        maxLen = max(maxLen, len(dequeue))

        return maxLen


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().lengthOfLongestSubstring('pwk3'))
    pass
