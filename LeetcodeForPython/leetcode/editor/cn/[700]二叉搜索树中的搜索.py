from typing import *


# 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
# 
#  例如， 
# 
#  
# 给定二叉搜索树:
# 
#         4
#        / \
#       2   7
#      / \
#     1   3
# 
# 和值: 2
#  
# 
#  你应该返回如下子树: 
# 
#  
#       2     
#      / \   
#     1   3
#  
# 
#  在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
#  Related Topics 树 
#  👍 93 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class Solution:
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root: return None
        if root.val == val:
            return root
        elif val < root.val:
            # 如果小于根节点值，肯定就在左子树中
            return self.searchBST(root.left, val)
        else:
            return self.searchBST(root.right, val)

        # bfs
        # queue = collections.deque()
        # if root: queue.append(root)
        # while queue:
        #     cur = queue.popleft()
        #     if cur.val == val: return cur
        #     if cur.left: queue.append(cur.left)
        #     if cur.right: queue.append(cur.right)
        #
        # return None


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
