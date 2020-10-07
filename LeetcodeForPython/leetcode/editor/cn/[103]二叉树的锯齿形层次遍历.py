from typing import *


# 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
# 
#  例如： 
# 给定二叉树 [3,9,20,null,null,15,7], 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7
#  
# 
#  返回锯齿形层次遍历如下： 
# 
#  [
#   [3],
#   [20,9],
#   [15,7]
# ]
#  
#  Related Topics 栈 树 广度优先搜索 
#  👍 275 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.

import collections


class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        queue = collections.deque()
        if root: queue.append(root)
        count = 0  # 层数计数器

        while len(queue) > 0:
            level = []
            # 遍历本层的节点
            for i in range(len(queue)):
                cur = queue.popleft()
                # 将cur的有效子节点添加到队列中
                if cur.left: queue.append(cur.left)
                if cur.right: queue.append(cur.right)
                level.append(cur.val)

            if count % 2 == 0:
                res.append(level)
            else:
                res.append(level[::-1])

            # 层数计数器加1
            count += 1

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
