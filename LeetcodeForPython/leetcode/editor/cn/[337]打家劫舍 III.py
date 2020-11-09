from typing import *


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    def rob(self, root: TreeNode) -> int:
        # 返回选中本节点和不选中本节点，2种选择策略下，本节点的子树上被选择的节点最大权值和
        def dfs(node: TreeNode) -> List[int]:
            if not node: return [0, 0]

            l = dfs(node.left)
            r = dfs(node.right)

            # 选择本节点，则孩子节点不可选择
            select = node.val + l[1] + r[1]
            # 不选择本节点，孩子节点可选可不选
            notSelect = max(l[0], l[1]) + max(r[0], r[1])
            return [select, notSelect]

        if not root: return 0;
        res = dfs(root)
        return max(res[0], res[1])


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
