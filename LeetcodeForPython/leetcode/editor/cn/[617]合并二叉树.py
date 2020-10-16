from typing import *


# 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
# 
#  你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
# 。 
# 
#  示例 1: 
# 
#  
# 输入: 
# 	Tree 1                     Tree 2                  
#           1                         2                             
#          / \                       / \                            
#         3   2                     1   3                        
#        /                           \   \                      
#       5                             4   7                  
# 输出: 
# 合并后的树:
# 	     3
# 	    / \
# 	   4   5
# 	  / \   \ 
# 	 5   4   7
#  
# 
#  注意: 合并必须从两个树的根节点开始。 
#  Related Topics 树 
#  👍 553 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        # 返回两树合成后的节点
        def recur(node1: TreeNode, node2: TreeNode) -> TreeNode:
            # 递归头
            if not node1: return node2
            if not node2: return node1

            # 设置本层节点
            root = TreeNode(node1.val + node2.val)
            # 递归设置左右子树
            root.left = recur(node1.left, node2.left)
            root.right = recur(node1.right, node2.right)
            return root

        return recur(t1, t2)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
