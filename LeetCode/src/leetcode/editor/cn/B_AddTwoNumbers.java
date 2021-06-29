package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class B_AddTwoNumbers {
    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        System.out.println(solution.addTwoNumbers(node1, node4));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            int add = 0;
            int sum;
            while (l1 != null && l2 != null) {
                sum = l1.val + l2.val + add;
                add = sum / 10;
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                sum = l1.val + add;
                add = sum / 10;
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                sum = l2.val + add;
                add = sum / 10;
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l2 = l2.next;
            }
            if (add != 0) {
                cur.next = new ListNode(add);
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}