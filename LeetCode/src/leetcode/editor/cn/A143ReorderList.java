package leetcode.editor.cn;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 341 👎 0

public class A143ReorderList {
    public static void main(String[] args) {
        Solution solution = new A143ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            if (head == null) return;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            //快慢指针法：分为2组链表进行合并
            ListNode l1 = head;
            ListNode l2 = slow.next;
            slow.next = null; //移除l1和l2之间的链接

            //递归法：反转l2
            l2 = reverse(l2);

            //合并l1，l2
            while (l1 != null && l2 != null) {
                ListNode temp1 = l1.next;
                ListNode temp2 = l2.next;

                l1.next = l2;
                l2.next = temp1;

                l1 = temp1;
                l2 = temp2;
            }
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newHead = reverse(head.next);

            head.next.next = head;  //将本层节点与后继节点反转
            head.next = null;   //并将本层节点的next域置空
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}