from typing import *


# 给定两个二叉树，编写一个函数来检验它们是否相同。
# 
#  如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
# 
#  示例 1: 
# 
#  输入:       1         1
#           / \       / \
#          2   3     2   3
# 
#         [1,2,3],   [1,2,3]
# 
# 输出: true 
# 
#  示例 2: 
# 
#  输入:      1          1
#           /           \
#          2             2
# 
#         [1,2],     [1,null,2]
# 
# 输出: false
#  
# 
#  示例 3: 
# 
#  输入:       1         1
#           / \       / \
#          2   1     1   2
# 
#         [1,2,1],   [1,1,2]
# 
# 输出: false
#  
#  Related Topics 树 深度优先搜索 
#  👍 482 👎 0

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        # 前序遍历
        # 如果2个节点同时为空
        if not p and not q:
            return True
        # 如果有1个为空
        elif not p or not q:
            return False
        # 如果值不相等
        elif p.val != q.val:
            return False
        # 如果本层节点的值相等，则递归进行下一层的比较
        else:
            # 返回2个子节点比较的结果
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
