from typing import *


# 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
# 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
# 
#  
# 
#  示例： 
# 
#  给定一个链表: 1->2->3->4->5, 和 k = 2.
# 
# 返回链表 4->5. 
#  Related Topics 链表 双指针 
#  👍 83 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        """
        思路：双指针
        former先走k步，此后每轮former和latter都走一步
        :param head:
        :param k:
        """
        fast = head
        slow = head
        # former先走k步
        for i in range(k):
            fast = fast.next

        while fast is not None:
            fast = fast.next
            slow = slow.next

        # 此时fast为None
        return slow


# class Solution:
#     def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
#         """
#         思路：
#         :param head:已知头节点
#         :param k:
#         """
#         cur = head
#         length = 0
#         res = []
#
#         # 遍历链表，将节点存入列表中
#         while cur is not None:
#             res.append(cur)
#             cur = cur.next
#             length += 1
#
#         return res[length - k]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
