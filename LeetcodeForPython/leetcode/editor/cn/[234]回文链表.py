from typing import *


# 请判断一个链表是否为回文链表。
# 
#  示例 1: 
# 
#  输入: 1->2
# 输出: false 
# 
#  示例 2: 
# 
#  输入: 1->2->2->1
# 输出: true
#  
# 
#  进阶： 
# 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
#  Related Topics 链表 双指针 
#  👍 645 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # noinspection PyAttributeOutsideInit
        self.front_pointer = head

        def recursively_check(current_node=head) -> bool:
            # 递归头：递归到最后一个节点结束
            if current_node is not None:
                # 递归进入下一层
                if not recursively_check(current_node.next): return False
                # 匹配判断
                if self.front_pointer.val != current_node.val: return False
                # 相匹配的话对front_pointer进行迭代
                self.front_pointer = self.front_pointer.next
            return True

        # 实际执行代码
        return recursively_check()


# 时间复杂度O(N)，空间复杂度O(N)
# class Solution:
#     def isPalindrome(self, head: ListNode) -> bool:
#         if head is None: return True
#
#         res = []
#         cur = head
#         while cur:
#             res.append(cur.val)
#             cur = cur.next
#         # 此时cur=None
#         return res == res[::-1]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
