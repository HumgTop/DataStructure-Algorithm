package leetcode.editor.cn;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1037 👎 0

public class A19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new A19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //双指针
            if (head.next == null) return null;

            ListNode cur = head;
            //cur指针先走n步
            for (int i = 0; i < n; i++) {
                //如果删除的是头节点，直接返回head.next
                if (cur.next == null) return head.next;
                cur = cur.next;
            }

            ListNode del = head;
            while (cur.next != null) {
                cur = cur.next;
                del = del.next;
            }

            //此时del指向了需删除节点的前驱节点
            del.next = del.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}