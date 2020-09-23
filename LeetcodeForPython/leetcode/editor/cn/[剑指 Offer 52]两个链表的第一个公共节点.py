from typing import *


# 输入两个链表，找出它们的第一个公共节点。
# 
#  如下面的两个链表： 
# 
#  
# 
#  在节点 c1 开始相交。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
# kipB = 3
# 输出：Reference of the node with value = 8
# 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
# ,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
#  
# 
#  
# 
#  示例 2： 
# 
#  
# 
#  输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
#  1
# 输出：Reference of the node with value = 2
# 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
# ]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
#  
# 
#  
# 
#  示例 3： 
# 
#  
# 
#  输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
# 输出：null
# 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
#  skipA 和 skipB 可以是任意值。
# 解释：这两个链表不相交，因此返回 null。
#  
# 
#  
# 
#  注意： 
# 
#  
#  如果两个链表没有交点，返回 null. 
#  在返回结果后，两个链表仍须保持原有的结构。 
#  可假定整个链表结构中没有循环。 
#  程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
#  本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
# ts/ 
#  
#  Related Topics 链表 
#  👍 103 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # noinspection PyUnresolvedReferences
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curA = headA
        curB = headB

        while curA != curB:
            curA = curA.next if curA is not None else headB
            curB = curB.next if curB is not None else headA

        # 此时curA==curB（有可能curA==curB==None)
        return curA


# class Solution:
#     # noinspection PyUnresolvedReferences
#     def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
#         """
#         思路：headA和headB都递推到最底层，然后每次回溯进行值的比较，
#         用全局变量记录值相同的节点，一旦不匹配持续返回false回溯到顶层
#         :param headA:
#         :param headB:
#         """
#         res = None
#
#         def recursion(curA=headA, curB=headB):
#             # 递归头
#             if curA or curB is not None:  # 向下递推
#                 # 如果下一层返回false，则本层也返回false
#                 if not recursion(curA.next,curB.next): return False


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = None
    b = None
    print(a == b)
    pass
