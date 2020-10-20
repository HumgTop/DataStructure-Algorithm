from typing import *


# 根据一棵树的前序遍历与中序遍历构造二叉树。 
# 
#  注意: 
# 你可以假设树中没有重复的元素。 
# 
#  例如，给出 
# 
#  前序遍历 preorder = [3,9,20,15,7]
# 中序遍历 inorder = [9,3,15,20,7] 
# 
#  返回如下的二叉树： 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7 
#  Related Topics 树 深度优先搜索 数组 
#  👍 719 👎 0

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:
    # noinspection PyTypeChecker
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        hashMap = {}  # 构建哈希表，key为node.val，value为node.val在inorder中的索引

        for i, val in enumerate(inorder):
            hashMap[val] = i

        # noinspection PyShadowingNames,PyTypeChecker
        def recur(hashMap: dict, preLeft, preRight, inLeft, inRight) -> TreeNode:
            """
            :param hashMap:
            :param preLeft: 指向前序遍历结果的起始索引
            :param preRight: 前序遍历结果的结束索引
            :param inLeft:
            :param inRight:
            :return:
            """
            if preLeft > preRight: return None
            # 创建根节点
            root = TreeNode(preorder[preLeft])
            # 定位根节点在inorder中的位置
            inorderRootIndex = hashMap[root.val]
            # 左子树的节点数
            leftSubtreeSize = inorderRootIndex - inLeft

            root.left = recur(hashMap, preLeft + 1, preLeft + leftSubtreeSize, inLeft, inorderRootIndex - 1)
            root.right = recur(hashMap, preLeft + leftSubtreeSize + 1, preRight, inorderRootIndex + 1, inRight)

            return root

        if not preorder: return None
        n = len(preorder)
        return recur(hashMap, 0, n - 1, 0, n - 1)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().buildTree([1, 2], [2, 1]))
    pass
