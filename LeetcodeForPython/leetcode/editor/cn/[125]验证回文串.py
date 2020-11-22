from typing import *


# 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
# 
#  说明：本题中，我们将空字符串定义为有效的回文串。 
# 
#  示例 1: 
# 
#  输入: "A man, a plan, a canal: Panama"
# 输出: true
#  
# 
#  示例 2: 
# 
#  输入: "race a car"
# 输出: false
#  
#  Related Topics 双指针 字符串 
#  👍 294 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPalindrome(self, s: str) -> bool:
        sList = list(s)
        left = 0
        right = len(sList) - 1

        while left <= right:
            while left <= right and not (sList[left].isalpha() or sList[left].isdigit()): left += 1
            while left <= right and not (sList[right].isalpha() or sList[right].isdigit()): right -= 1
            if sList[left].lower() != sList[right].lower(): return False
            left += 1
            right -= 1

        return True


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().isPalindrome("a,,,#ba"))
    pass
