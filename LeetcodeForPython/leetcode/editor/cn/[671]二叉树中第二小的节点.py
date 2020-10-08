from typing import *


# 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
# 个。 
# 
#  给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
# 
#  示例 1: 
# 
#  输入: 
#     2
#    / \
#   2   5
#      / \
#     5   7
# 
# 输出: 5
# 说明: 最小的值是 2 ，第二小的值是 5 。
#  
# 
#  示例 2: 
# 
#  输入: 
#     2
#    / \
#   2   2
# 
# 输出: -1
# 说明: 最小的值是 2, 但是不存在第二小的值。
#  
#  Related Topics 树 
#  👍 115 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        # dfs将所以节点值添加到set中（去重），然后转为list进行排序获取
        hashSet = set()

        # 前序遍历添加
        def recur(node: TreeNode):
            if not node: return
            hashSet.add(node.val)
            recur(node.left)
            recur(node.right)

        recur(root)
        res = sorted(list(hashSet))
        return res[1] if len(res) > 1 else -1


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
