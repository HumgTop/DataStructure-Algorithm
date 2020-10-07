from typing import *


# 给定一个 N 叉树，返回其节点值的后序遍历。
# 
#  例如，给定一个 3叉树 : 
# 
#  
# 
#  
# 
#  
# 
#  返回其后序遍历: [5,6,3,2,4,1]. 
# 
#  
# 
#  说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
#  👍 103 👎 0

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.

"""


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root: return []
        # 递归法
        res = []

        def rescur(node: Node):
            # 递归头
            if not node: return
            for child in node.children:
                rescur(child)

            # 从下层返回后，本层的执行代码
            res.append(node.val)

        rescur(root)
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
