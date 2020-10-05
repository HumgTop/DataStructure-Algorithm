from typing import *


# 给定一个二叉树，返回它的中序 遍历。
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
# 输出: [1,3,2] 
# 
#  进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
#  Related Topics 栈 树 哈希表 
#  👍 736 👎 0

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root: return []
        # 迭代法
        stack = collections.deque()
        res = []
        cur = root
        while cur or stack:
            # 当cur不为空时
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right

        return res

        # 递归法
        # res = []
        #
        # def rescur(node: TreeNode):
        #     # 如果当前节点不为空
        #     if node:
        #         rescur(node.left)
        #         res.append(node.val)
        #         rescur(node.right)
        #
        # rescur(root)
        # return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
