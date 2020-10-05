from typing import *


# 给定一个二叉树，判断它是否是高度平衡的二叉树。
# 
#  本题中，一棵高度平衡二叉树定义为： 
# 
#  
#  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
#  
# 
#  示例 1: 
# 
#  给定二叉树 [3,9,20,null,null,15,7] 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7 
# 
#  返回 true 。 
#  
# 示例 2: 
# 
#  给定二叉树 [1,2,2,3,3,null,null,4,4] 
# 
#         1
#       / \
#      2   2
#     / \
#    3   3
#   / \
#  4   4
#  
# 
#  返回 false 。 
# 
#  
#  Related Topics 树 深度优先搜索 
#  👍 488 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.recur(root) != -1

    def recur(self, root) -> int:
        # 如果为空树
        if not root: return 0
        # 向下递归，遍历左子树
        left = self.recur(root.left)
        # 如果判定不是平衡树，剪枝向上返回
        if left == -1: return -1
        # 向下递归，遍历右子树
        right = self.recur(root.right)
        if right == -1: return -1
        # 如果是平衡树的话，返回当前root节点的高度
        return max(left, right) + 1 if abs(left - right) < 2 else -1


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
