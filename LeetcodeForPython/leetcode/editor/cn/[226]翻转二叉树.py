from typing import *


# 翻转一棵二叉树。
# 
#  示例： 
# 
#  输入： 
# 
#       4
#    /   \
#   2     7
#  / \   / \
# 1   3 6   9 
# 
#  输出： 
# 
#       4
#    /   \
#   7     2
#  / \   / \
# 9   6 3   1 
# 
#  备注: 
# 这个问题是受到 Max Howell 的 原问题 启发的 ： 
# 
#  谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
#  Related Topics 树 
#  👍 645 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # 如果root节点为空，返回root
        if not root: return root
        left = self.invertTree(root.left)
        right = self.invertTree(root.right)
        root.right = left
        root.left = right
        return root


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
