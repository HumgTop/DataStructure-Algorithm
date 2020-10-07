from typing import *


# 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
# 
#  说明： 
# 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
# 
#  示例 1: 
# 
#  输入: root = [3,1,4,null,2], k = 1
#    3
#   / \
#  1   4
#   \
#    2
# 输出: 1 
# 
#  示例 2: 
# 
#  输入: root = [5,3,6,2,4,null,null,1], k = 3
#        5
#       / \
#      3   6
#     / \
#    2   4
#   /
#  1
# 输出: 3 
# 
#  进阶： 
# 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
#  Related Topics 树 二分查找 
#  👍 293 👎 0
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class Solution:
    count = 0

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = collections.deque()
        # 优解：迭代法
        # 中序遍历
        while True:
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()
            k -= 1
            if not k: return root.val
            root = root.right

        # 自解
        # """
        # 相当于中序遍历，在回溯阶段，每回溯一层k--，直到k==0时，返回当前节点值
        # :param root:
        # :param k:
        # :return:
        # """
        # def rescur(node: TreeNode) -> int:
        #     if not node: return -1  # 递归到空节点返回-1
        #
        #     flag = rescur(node.left)
        #     # 从下层回溯后执行的代码
        #     if flag != -1: return flag  # 如果已经找到最小值，直接返回，本层不再进行处理
        #
        #     Solution.count -= 1
        #     if Solution.count == 0: return node.val
        #
        #     flag = rescur(node.right)
        #     if flag != -1: return flag
        #
        #     return -1  # 本层未找到，返回-1到上一层
        #
        # Solution.count = k
        # return rescur(root)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
