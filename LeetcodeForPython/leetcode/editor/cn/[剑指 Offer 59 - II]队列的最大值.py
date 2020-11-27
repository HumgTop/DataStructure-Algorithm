from typing import *

# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque as dq


class myLinkedList:
    def __init__(self, val=0):
        self.val = val
        self.next = None


class MaxQueue:

    def __init__(self):
        self.head = myLinkedList()
        self.tail = self.head
        self.maxVal = float('-inf')
        self.deque = dq()

    def max_value(self) -> int:
        if not self.head.next: return -1
        return self.deque[0]

    def push_back(self, value: int) -> None:
        self.tail.next = myLinkedList(value)
        self.tail = self.tail.next

        # 更新deque
        while self.deque and value > self.deque[-1]:
            self.deque.pop()
        self.deque.append(value)

    def pop_front(self) -> int:
        if not self.head.next: return -1
        res = self.head.next.val
        # 如果此时队列内只有1个节点
        if not self.head.next.next:
            self.tail = self.head
        self.head.next = self.head.next.next

        # 处理deque
        if self.deque and res == self.deque[0]: self.deque.popleft()
        return res


# Your MaxQueue object will be instantiated and called as such:
# obj = MaxQueue()
# param_1 = obj.max_value()
# obj.push_back(value)
# param_3 = obj.pop_front()
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    q = MaxQueue()
    print(q.max_value())
    print(q.pop_front())
    print(q.max_value())
    q.push_back(46)
    print(q.max_value())
    print(q.pop_front())
    print(q.max_value())
    print(q.pop_front())
    print(q.push_back(868))
    print(q.max_value())
    pass
