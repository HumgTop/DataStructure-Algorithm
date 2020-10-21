from typing import *


# 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
# 
#  示例 1: 
# 
#  输入: 4->2->1->3
# 输出: 1->2->3->4
#  
# 
#  示例 2: 
# 
#  输入: -1->5->3->4->0
# 输出: -1->0->3->4->5 
#  Related Topics 排序 链表 
#  👍 786 👎 0

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.



class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        """
        :param head:
        :return: 排好序的链表的头节点
        """
        # 归并排序：分割、合并
        # 切分到只有单个节点时，递归结束开始回溯
        if not head or not head.next: return head

        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        # 奇数个节点，slow到达中点。偶数个节点，slow到达中点左侧的节点
        mid = slow.next
        slow.next = None

        left = self.sortList(head)
        right = self.sortList(mid)

        helper = dummyHead = ListNode(0)  # 合并后链表的头节点，helper为辅助指针
        # 对left和right进行合并排序
        while left and right:
            if left.val < right.val:
                helper.next, left = left, left.next
            else:
                helper.next, right = right, right.next
            helper = helper.next
        # 当left或right有一个已经遍历完成，另一个还有剩余
        helper.next = left if left else right

        return dummyHead.next


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
