from typing import *


# 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
# 
#  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
# 
#  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
# 
#  示例： 
# 
#  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
# 输出：7 -> 0 -> 8
# 原因：342 + 465 = 807
#  
#  Related Topics 链表 数学 
#  👍 5126 👎 0

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1: return l2
        if not l2: return l1

        dummyHead = cur = ListNode(0)
        carry = 0

        while l1 and l2:
            curSum = l1.val + l2.val + carry
            cur.next = ListNode(curSum % 10)
            cur, l1, l2 = cur.next, l1.next, l2.next
            carry = 1 if curSum > 9 else 0

        if not l1 and not l2 and carry:
            cur.next = ListNode(carry)

        elif l1:
            while l1 and carry:
                curSum = l1.val + carry
                cur.next = ListNode(curSum % 10)
                cur, l1 = cur.next, l1.next
                carry = 1 if curSum > 9 else 0

            # 如果还有进位
            if not l1 and carry:
                cur.next = ListNode(carry)
            else:
                cur.next = l1

        elif l2:
            while l2 and carry:
                curSum = l2.val + carry
                cur.next = ListNode(curSum % 10)
                cur, l2 = cur.next, l2.next
                carry = 1 if curSum > 9 else 0

            if not l2 and carry:
                cur.next = ListNode(carry)
            else:
                cur.next = l2

        return dummyHead.next


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
