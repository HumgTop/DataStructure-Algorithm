from typing import *

# 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
# 是 4 次，则需要在最终答案中包含该字符 3 次。 
# 
#  你可以按任意顺序返回答案。 
# 
#  
# 
#  示例 1： 
# 
#  输入：["bella","label","roller"]
# 输出：["e","l","l"]
#  
# 
#  示例 2： 
# 
#  输入：["cool","lock","cook"]
# 输出：["c","o"]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= A.length <= 100 
#  1 <= A[i].length <= 100 
#  A[i][j] 是小写字母 
#  
#  Related Topics 数组 哈希表 
#  👍 127 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        # 计数
        minFreq = [float('inf')] * 26
        for word in A:
            freq = [0] * 26
            for letter in word:
                freq[ord(letter) - ord('a')] += 1  # 记录Word中字母出现的次数
            # 更新minFreq
            for i in range(26):
                minFreq[i] = min(minFreq[i], freq[i])

        # 输出结果
        res = []
        for i in range(26):
            for j in range(minFreq[i]):
                res.append(chr(i + ord('a')))

        return res

        # counter = collections.Counter(A[0])
        #
        # for s in A:
        #     counter &= collections.Counter(s)
        #
        # return list(counter.elements())


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(float('inf'))
    pass
