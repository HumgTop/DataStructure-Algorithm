package leetcode.editor.cn;

public class A_328OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new A_328OddEvenLinkedList().new Solution();
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
        ListNode dummyEvenHead;

        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }

            dummyEvenHead = new ListNode();
            dummyEvenHead.next = head.next;

            recur(head, head.next);
            return head;
        }

        void recur(ListNode node, ListNode nodeNext) {
            if (nodeNext == null || nodeNext.next == null) {
                //如果链表长度为奇数和为偶数时，遍历到尾部的情况
                node.next = dummyEvenHead.next;
                return;
            }

            node.next = nodeNext.next;
            nodeNext.next = nodeNext.next.next;

            recur(node.next, nodeNext.next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}