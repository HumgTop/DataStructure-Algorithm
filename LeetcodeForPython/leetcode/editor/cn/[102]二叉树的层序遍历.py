from typing import *


# 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
# 
#  
# 
#  示例： 
# 二叉树：[3,9,20,null,null,15,7], 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7
#  
# 
#  返回其层次遍历结果： 
# 
#  [
#   [3],
#   [9,20],
#   [15,7]
# ]
#  
#  Related Topics 树 广度优先搜索 
#  👍 662 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        queue = collections.deque()
        # 先添加root节点
        if root: queue.append(root)
        while len(queue) > 0:
            level = []  # 保存每层的元素
            # 将本层元素全部出列
            for i in range(len(queue)):
                cur = queue.popleft()
                # 如果邻接点有效，添加到队列中
                if cur.left: queue.append(cur.left)
                if cur.right: queue.append(cur.right)
                level.append(cur.val)  # 记录本层元素的值

            # 记录完毕，将level添加到res中
            res.append(level)

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
