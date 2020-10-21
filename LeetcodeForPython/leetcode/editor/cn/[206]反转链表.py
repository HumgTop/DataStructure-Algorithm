from typing import *


# 反转一个单链表。
# 
#  示例: 
# 
#  输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL 
# 
#  进阶: 
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
#  Related Topics 链表 
#  👍 1287 👎 0

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # 递归
        if not head or not head.next: return head  # 找到新的头节点
        newHead = self.reverseList(head.next)

        head.next.next = head  # 后继节点的后继节点为本节点
        head.next = None  # 将本节点的后继节点置空（返回上一层后继续设置）

        return newHead
        # 迭代
        # if not head or not head.next: return head
        # stack = []
        #
        # while head.next:
        #     stack.append(head)
        #     head = head.next
        #
        # # 当head.next=None时，说明遍历到最后一个节点，即为新的头节点
        # newHead = head
        # while stack:
        #     head.next = stack.pop()
        #     head = head.next
        # head.next = None
        #
        # return newHead

        # if not head or not head.next: return head
        # res = None
        #
        # def recur(node: ListNode, parent: ListNode = None):
        #     # 如果遍历到最后一个节点，不再递归，它即是新的头节点
        #     if not node.next:
        #         nonlocal res
        #         res = node
        #         node.next = parent
        #     # 如果当前节点不为空
        #     else:
        #         recur(node.next, node)  # 为每层的parent变量赋值
        #         node.next = parent  # 回溯阶段，后继节点的next域指向前驱节点
        #
        # recur(head)
        # return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
