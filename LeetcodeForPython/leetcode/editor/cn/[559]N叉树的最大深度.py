from typing import *


# 给定一个 N 叉树，找到其最大深度。 
# 
#  最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
# 
#  例如，给定一个 3叉树 : 
# 
#  
# 
#  
# 
#  
# 
#  我们应返回其最大深度，3。 
# 
#  说明: 
# 
#  
#  树的深度不会超过 1000。 
#  树的节点总不会超过 5000。 
#  Related Topics 树 深度优先搜索 广度优先搜索 
#  👍 124 👎 0

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.

"""


class Solution:
    def maxDepth(self, root: 'Node') -> int:
        self.depth = 0

        def dfs(node: Node, depth: int):
            if not node: return
            self.depth = max(self.depth, depth)
            for child in node.children:
                dfs(child, depth + 1)

        dfs(root, 1)
        return self.depth


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
