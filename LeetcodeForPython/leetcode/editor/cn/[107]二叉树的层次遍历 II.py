from typing import *


# 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
# 
#  例如： 
# 给定二叉树 [3,9,20,null,null,15,7], 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7
#  
# 
#  返回其自底向上的层次遍历为： 
# 
#  [
#   [15,7],
#   [9,20],
#   [3]
# ]
#  
#  Related Topics 树 广度优先搜索 
#  👍 343 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.

import collections


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        # dfs方法
        res = collections.deque()  # 存放结果（因为不知道树的深度，所以将res的初始化放在递归中进行）

        def recur(node: TreeNode, depth: int):
            if not node: return
            # 每递归到新一层，在res头部添加一个新列表
            if depth == len(res): res.appendleft([])
            # 将本层节点添加到res中对应的level中
            res[-depth - 1].append(node.val)
            # 向下递归处理
            recur(node.left, depth + 1)
            recur(node.right, depth + 1)

        recur(root, 0)
        return list(res)

        # 思路：bfs后对结果逆序
        # queue = collections.deque()
        # res = []  # 二维列表，存放每层的一维level结果
        # if root: queue.append(root)
        # while queue:
        #     level = []
        #     for i in range(len(queue)):
        #         node = queue.popleft()
        #         # 添加本层元素的子节点
        #         if node.left: queue.append(node.left)
        #         if node.right: queue.append(node.right)
        #         # 将本层元素添加到level中
        #         level.append(node.val)
        #     res.append(level)
        #
        # res.reverse()
        # return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
