from typing import *


# 给定一个二叉树，原地将它展开为一个单链表。 
# 
#  
# 
#  例如，给定二叉树 
# 
#      1
#    / \
#   2   5
#  / \   \
# 3   4   6 
# 
#  将其展开为： 
# 
#  1
#  \
#   2
#    \
#     3
#      \
#       4
#        \
#         5
#          \
#           6 
#  Related Topics 树 深度优先搜索 
#  👍 593 👎 0

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # 空间复杂度为o1的解法
        cur = root
        while cur:
            if cur.left:
                pre = nxt = cur.left
                # 找到左子树中最右边的节点作为前驱节点（cur.right的前驱节点）
                while pre.right:
                    pre = pre.right
                # 将pre.right连接到cur.right
                pre.right = cur.right
                cur.left = None
                cur.right = nxt
            cur = cur.right

        # allNode = []
        #
        # # 前序遍历
        # def dfs(node: TreeNode):
        #     allNode.append(node)
        #     if node.left: dfs(node.left)
        #     if node.right: dfs(node.right)
        #
        # if not root: return
        # dfs(root)
        #
        # n = len(allNode)
        # for i in range(1, n):
        #     pre, cur = allNode[i - 1], allNode[i]
        #     pre.left = None
        #     pre.right = cur


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
