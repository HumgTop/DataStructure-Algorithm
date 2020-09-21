from typing import *


# 给你两个数组，arr1 和 arr2，
# 
#  
#  arr2 中的元素各不相同 
#  arr2 中的每个元素都出现在 arr1 中 
#  
# 
#  对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
# 尾。 
# 
#  
# 
#  示例： 
# 
#  输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
# 输出：[2,2,2,1,4,3,3,9,6,7,19]
#  
# 
#  
# 
#  提示： 
# 
#  
#  arr1.length, arr2.length <= 1000 
#  0 <= arr1[i], arr2[i] <= 1000 
#  arr2 中的元素 arr2[i] 各不相同 
#  arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
#  
#  Related Topics 排序 数组 
#  👍 79 👎 0


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    @staticmethod
    def relativeSortArray(arr1: List[int], arr2: List[int]) -> List[int]:
        """
        # 统计arr1中所有元素出现的频次，将arr1转为set
        :param arr1: 有重复元素
        :param arr2: 无重复元素，所有元素都出现在arr1中
        """
        # 使用字典，key为元素值，value为出现次数
        count = {}
        for key in arr1:
            # 如果键在字典中
            if key in count:
                count[key] += 1
            else:
                count[key] = 1

        arr1 = set(arr1)
        arr1.difference_update(arr2)  # 更新arr1为arr1与arr2的差集
        arr1 = list(arr1)
        arr1.sort()

        result = []
        for key in arr2:
            # 从count中获取该值的出现次数
            result += [key] * count[key]

        for key in arr1:
            result += [key] * count[key]

        return result


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = {3, 4, 5, 9}
    print(a)
    pass
