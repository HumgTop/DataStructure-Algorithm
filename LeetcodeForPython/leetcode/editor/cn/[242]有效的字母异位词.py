from typing import *


# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
# 
#  示例 1: 
# 
#  输入: s = "anagram", t = "nagaram"
# 输出: true
#  
# 
#  示例 2: 
# 
#  输入: s = "rat", t = "car"
# 输出: false 
# 
#  说明: 
# 你可以假设字符串只包含小写字母。 
# 
#  进阶: 
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
#  Related Topics 排序 哈希表 
#  👍 253 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False

        cnt = [0] * 26  # 字母计数器
        for ch in s:
            cnt[ord(ch) - ord('a')] += 1

        for ch in t:
            if cnt[ord(ch) - ord('a')] == 0:
                return False
            cnt[ord(ch) - ord('a')] -= 1

        for val in cnt:
            if val != 0: return False

        # 如果字母计数器的所有值都为0，返回True
        return True


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s = ['a', 'd', 'g', 'e', 'd', 'g', 'e']
    t = ['b', 'a']
    s.sort()
    print(s)
    pass
