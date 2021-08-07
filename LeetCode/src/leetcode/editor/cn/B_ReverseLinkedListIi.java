package leetcode.editor.cn;

import org.junit.Test;


public class B_ReverseLinkedListIi {
    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        helper(head);
        System.out.println(head.val);
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

    ListNode helper(ListNode head) {
        head = head.next;
        return head;
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            ListNode[] cutRes1 = cut(dummyHead, right);
            ListNode node3 = cutRes1[0];
            ListNode node4 = cutRes1[1];
            ListNode[] cutRes2 = cut(dummyHead, left - 1);
            ListNode node1 = cutRes2[0];
            ListNode node2 = cutRes2[1];
            //反转node2到node3
            reverse(node2);
            node1.next = node3;
            node2.next = node4;

            return head;
        }

        //切割第idx和idx+1节点，并返回idx+1节点。head是第1个节点
        ListNode[] cut(ListNode head, int idx) {
            for (int i = 0; i < idx; i++) {
                head = head.next;
            }
            ListNode temp = head.next;
            head.next = null;
            ListNode[] res = new ListNode[2];
            res[0] = head;
            res[1] = temp;
            return res;
        }

        ListNode reverse(ListNode node) {
            if (node.next == null) {
                return node;
            }
            ListNode newHead = reverse(node.next);
            //newHead的尾节点是node.next
            node.next.next = node;
            node.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}