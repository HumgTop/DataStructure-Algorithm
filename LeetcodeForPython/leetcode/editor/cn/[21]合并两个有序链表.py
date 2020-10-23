from typing import *


# 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
# 
#  
# 
#  示例： 
# 
#  输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
#  
#  Related Topics 链表 
#  👍 1340 👎 0

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummyHead = cur = ListNode(0)

        # 递归法
        def recur(left, right):
            nonlocal cur
            if left and right:
                cur.next = left if left.val < right.val else right
                cur = cur.next
                recur(left.next, right) if left.val < right.val else recur(left, right.next)
            else:
                cur.next = left if left else right

        recur(l1, l2)
        return dummyHead.next

        # 迭代法
        # # 双指针遍历2个链表，将节点依次添加到dummyHead之后
        # while l1 and l2:
        #     if l1.val < l2.val:
        #         cur.next = l1
        #         l1 = l1.next
        #     else:
        #         cur.next = l2
        #         l2 = l2.next
        #
        #     cur = cur.next
        #
        # # 当其中1个链表遍历完成后，将另一个链表的剩余部分链接到cur之后
        # cur.next = l1 if l1 else l2
        #
        # return dummyHead.next


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
