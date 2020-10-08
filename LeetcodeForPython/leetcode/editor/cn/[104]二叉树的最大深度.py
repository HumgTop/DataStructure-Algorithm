from typing import *


# 给定一个二叉树，找出其最大深度。
# 
#  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
# 
#  说明: 叶子节点是指没有子节点的节点。 
# 
#  示例： 
# 给定二叉树 [3,9,20,null,null,15,7]， 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7 
# 
#  返回它的最大深度 3 。 
#  Related Topics 树 深度优先搜索 
#  👍 714 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.

import collections


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # 广度优先搜索
        queue = collections.deque()
        if root: queue.append(root)
        level = 0  # 记录层数
        while queue:
            # 本层节点全部出列
            for i in range(len(queue)):
                cur = queue.popleft()
                # 添加下一层的节点
                if cur.left: queue.append(cur.left)
                if cur.right: queue.append(cur.right)
            level += 1

        return level

        # def rescur(height: int, node: TreeNode) -> int:
        #     if not node: return height  # 递归头：如果遍历到空节点，返回父节点的高度
        #     # 对下层返回结果进行处理
        #     return max(rescur(height + 1, node.left), rescur(height + 1, node.right))
        #
        # return rescur(0, root)  # 初始高度为0


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
