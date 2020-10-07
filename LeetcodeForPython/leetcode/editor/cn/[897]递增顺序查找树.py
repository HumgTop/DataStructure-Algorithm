from typing import *


# 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
# 
#  
# 
#  示例 ： 
# 
#  输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
# 
#        5
#       / \
#     3    6
#    / \    \
#   2   4    8
#  /        / \ 
# 1        7   9
# 
# 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
# 
#  1
#   \
#    2
#     \
#      3
#       \
#        4
#         \
#          5
#           \
#            6
#             \
#              7
#               \
#                8
#                 \
#                  9  
# 
#  
# 
#  提示： 
# 
#  
#  给定树中的结点数介于 1 和 100 之间。 
#  每个结点都有一个从 0 到 1000 范围内的唯一整数值。 
#  
#  Related Topics 树 深度优先搜索 
#  👍 107 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        # 中序遍历
        def rescur(node: TreeNode):
            if not node: return  # 如果node为空，直接返回
            rescur(node.left)
            node.left = None
            self.cur.right = node
            self.cur = node  # cur指针移动到右子节点
            rescur(node.right)

        # 声明一个实例属性
        res = self.cur = TreeNode(0)
        rescur(root)
        return res.right


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
