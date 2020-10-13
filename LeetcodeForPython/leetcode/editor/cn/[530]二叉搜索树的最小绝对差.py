from typing import *


# 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
# 
#  
# 
#  示例： 
# 
#  输入：
# 
#    1
#     \
#      3
#     /
#    2
# 
# 输出：
# 1
# 
# 解释：
# 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中至少有 2 个节点。 
#  本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
# 相同 
#  
#  Related Topics 树 
#  👍 154 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        nodeVal = []

        # 中序遍历后，nodeVal为一个升序数组
        def inOrder(node: TreeNode):
            if not node: return  # 递归头
            inOrder(node.left)
            # 本层执行代码
            nodeVal.append(node.val)
            inOrder(node.right)

        inOrder(root)

        minDiff = abs(nodeVal[1] - nodeVal[0])
        for i in range(2, len(nodeVal)):
            absVal = abs(nodeVal[i] - nodeVal[i - 1])
            if absVal < minDiff: minDiff = absVal

        return minDiff


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
