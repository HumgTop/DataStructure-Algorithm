from typing import *


# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
# 
#  假设一个二叉搜索树具有如下特征： 
# 
#  
#  节点的左子树只包含小于当前节点的数。 
#  节点的右子树只包含大于当前节点的数。 
#  所有左子树和右子树自身必须也是二叉搜索树。 
#  
# 
#  示例 1: 
# 
#  输入:
#     2
#    / \
#   1   3
# 输出: true
#  
# 
#  示例 2: 
# 
#  输入:
#     5
#    / \
#   1   4
#      / \
#     3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
#      根节点的值为 5 ，但是其右子节点值为 4 。
#  
#  Related Topics 树 深度优先搜索 
#  👍 818 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # 使用该变量保存中序遍历的上一个结果
        preVal = float('-inf')

        def inOrder(node: TreeNode) -> bool:
            nonlocal preVal
            # 遇空节点返回
            if not node: return True
            # 如果左子树非法
            if not inOrder(node.left): return False
            # 如果本节点非法（如果本节点值比上个节点值小，不满足升序排列）
            if node.val <= preVal: return False

            preVal = node.val

            # 如果右子树非法
            if not inOrder(node.right): return False

            return True

        return inOrder(root)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
