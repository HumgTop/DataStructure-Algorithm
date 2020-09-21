from typing import *


# 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
# 
#  请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。 
# 
#  返回重新排列后的字符串。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
# 输出："leetcode"
# 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
#  
# 
#  示例 2： 
# 
#  输入：s = "abc", indices = [0,1,2]
# 输出："abc"
# 解释：重新排列后，每个字符都还留在原来的位置上。
#  
# 
#  示例 3： 
# 
#  输入：s = "aiohn", indices = [3,1,4,2,0]
# 输出："nihao"
#  
# 
#  示例 4： 
# 
#  输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
# 输出："arigatou"
#  
# 
#  示例 5： 
# 
#  输入：s = "art", indices = [1,0,2]
# 输出："rat"
#  
# 
#  
# 
#  提示： 
# 
#  
#  s.length == indices.length == n 
#  1 <= n <= 100 
#  s 仅包含小写英文字母。 
#  0 <= indices[i] < n 
#  indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。 
#  
#  Related Topics 排序 
#  👍 13 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        """
        思路：创建字典，key为indices[i]，value为
        :param s:
        :param indices: 调整s[i]到s[indices[i]]
        """
        table = dict(zip(indices, s))

        s = ''
        # 返回升序排列的key列表
        for key in sorted(table.keys()):
            s += table[key]
        return s


# class Solution:
#     def restoreString(self, s: str, indices: List[int]) -> str:
#         length = len(s)
#         result = [''] * length  # 字符列表
#         # 遍历s，并获得当前字符的索引
#         s = list(s)
#         for i in range(length):
#             result[indices[i]] = s[i]
#
#         # 将字符列表转为字符串
#         return ''.join(result)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
