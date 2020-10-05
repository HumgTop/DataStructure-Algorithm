from typing import *


# 给定一个 N 叉树，返回其节点值的前序遍历。
# 
#  例如，给定一个 3叉树 : 
# 
#  
# 
#  
# 
#  
# 
#  返回其前序遍历: [1,3,5,6,2,4]。 
# 
#  
# 
#  说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
#  👍 107 👎 0

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children  # 此处的children类型为List[Node]


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
"""

import collections


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        # 迭代法
        if not root: return []
        stack = collections.deque([root])
        res = []
        while stack:  # 当栈不为空时
            root = stack.pop()
            res.append(root.val)
            # 将root的子节点逆序入栈
            for child in root.children[::-1]:
                stack.append(child)

        return res

        # 递归法
        # if not root: return []  # 如果root为空节点，返回[]
        #
        # def dfs(res: List[int], node: Node):
        #     # 递归头
        #     if not node: return
        #     # 将父节点添加到res中
        #     res.append(node.val)
        #     # 如果子节点列表不为空
        #     if not node.children: return
        #     # 向下递归添加子节点
        #     for child in node.children:
        #         dfs(res, child)
        #
        # res = []
        # dfs(res, root)
        # return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
