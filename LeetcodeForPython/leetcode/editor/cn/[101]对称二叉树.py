from typing import *


# 给定一个二叉树，检查它是否是镜像对称的。 
# 
#  
# 
#  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
# 
#      1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
#  
# 
#  
# 
#  但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
# 
#      1
#    / \
#   2   2
#    \   \
#    3    3
#  
# 
#  
# 
#  进阶： 
# 
#  你可以运用递归和迭代两种方法解决这个问题吗？ 
#  Related Topics 树 深度优先搜索 广度优先搜索 
#  👍 1090 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.

import collections


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def recur(left: TreeNode, right: TreeNode) -> bool:
            # 终止条件
            if not left and not right: return True  # 叶子节点越界
            if not left or not right or (left.val != right.val): return False

            # 本层相同，返回下一层的结果
            return recur(left.left, right.right) and recur(left.right, right.left)

        if not root: return True
        return recur(root.left, root.right)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
