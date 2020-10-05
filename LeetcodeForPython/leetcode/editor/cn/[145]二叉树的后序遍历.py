from typing import *


# 给定一个二叉树，返回它的 后序 遍历。
# 
#  示例: 
# 
#  输入: [1,null,2,3]  
#    1
#     \
#      2
#     /
#    3 
# 
# 输出: [3,2,1] 
# 
#  进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
#  Related Topics 栈 树 
#  👍 452 👎 0

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        # 递归法
        res = []

        def rescur(node: TreeNode):
            if not node: return
            rescur(node.left)
            rescur(node.right)
            res.append(node.val)

        rescur(root)
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
