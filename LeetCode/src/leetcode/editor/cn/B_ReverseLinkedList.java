package leetcode.editor.cn;

import org.junit.Test;

import java.util.List;


public class B_ReverseLinkedList {
    @Test
    public void test() {
        Solution solution = new Solution();

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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;    //返回最后一个非空节点
            }

            ListNode newHead = reverseList(head.next);
            //此时链表尾节点为head.next，将head添加到尾节点
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}