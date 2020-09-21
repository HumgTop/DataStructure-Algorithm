from typing import *


# 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选
# 择同一个索引 i。） 
# 
#  以这种方式修改数组后，返回数组可能的最大和。 
# 
#  
# 
#  示例 1： 
# 
#  输入：A = [4,2,3], K = 1
# 输出：5
# 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
#  
# 
#  示例 2： 
# 
#  输入：A = [3,-1,0,2], K = 3
# 输出：6
# 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
#  
# 
#  示例 3： 
# 
#  输入：A = [2,-3,-1,5,-4], K = 2
# 输出：13
# 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= A.length <= 10000 
#  1 <= K <= 10000 
#  -100 <= A[i] <= 100 
#  
#  Related Topics 贪心算法 
#  👍 60 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        """
        贪心策略：
        1.尽可能让所有的负数取反
        2.如果 K 的值大于负数数目(count)，负数全部变号后
            1.如果剩余次数是偶数，那么可以不变化
            2.如果剩余次数是奇数，那么就要做个决策{
            变号最小非负数，还是最大负数
            }
        :param A: 待处理数组
        :param K: 取反次数
        """
        A.sort()  # 对数组A升序排列
        count = 0
        for i in range(len(A)):
            if count == K: return sum(A)
            if A[i] < 0:
                A[i] = -A[i]
                count += 1
            elif (K - count) % 2 == 1:
                # 此时必须将数组中的一个正数取反，在A[i]和A[i-1]中选出较小值取反
                if A[i] < A[i - 1]:
                    A[i] = -A[i]
                else:
                    A[i - 1] = -A[i - 1]
                break
            else:
                break
        return sum(A)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
