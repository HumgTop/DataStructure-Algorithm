from typing import *


# 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
#  node.val 的值之和。 
# 
#  提醒一下，二叉搜索树满足下列约束条件： 
# 
#  
#  节点的左子树仅包含键 小于 节点键的节点。 
#  节点的右子树仅包含键 大于 节点键的节点。 
#  左右子树也必须是二叉搜索树。 
#  
# 
#  注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
#  
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
# 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
#  
# 
#  示例 2： 
# 
#  输入：root = [0,null,1]
# 输出：[1,null,1]
#  
# 
#  示例 3： 
# 
#  输入：root = [1,0,2]
# 输出：[3,3,2]
#  
# 
#  示例 4： 
# 
#  输入：root = [3,2,4,1]
# 输出：[7,9,4,10]
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中的节点数介于 1 和 100 之间。 
#  每个节点的值介于 0 和 100 之间。 
#  树中的所有值 互不相同 。 
#  给定的树为二叉搜索树。 
#  
#  Related Topics 二叉搜索树 
#  👍 92 👎 0
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        preVal = -1  # 记录中序遍历过程前一个节点值

        # self.deque = collections.deque()
        #
        # # 递归 从右子树开始的中序遍历，将修改后的节点值入栈
        # def recur(node: TreeNode):
        #     if not node: return
        #     # 递归处理右子树
        #     recur(node.right)
        #     # 回溯到本层
        #     if len(self.deque) > 0: node.val += self.deque.pop()
        #     self.deque.append(node.val)  # 将累加结果入栈
        #     # 递归处理左子树
        #     recur(node.left)

        # 递归 从右子树开始的中序遍历，维护一个pre变量
        def recur(node: TreeNode):
            nonlocal preVal
            if not node: return
            # 递归处理右子树
            recur(node.right)
            # 回溯到本层
            if preVal != -1: node.val += preVal
            preVal = node.val  # 将累加结果入栈
            # 递归处理左子树
            recur(node.left)

        recur(root)
        return root


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
