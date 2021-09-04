package leetcode.editor.cn;

public class B_ReverseNodesInKGroup {
    public static void main(String[] args) {

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
        //返回重构后的头节点
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;

            int cnt = k;
            ListNode tail = head;
            while (cnt > 1) {
                //最后剩余的节点保持原有顺序
                if (tail.next == null) {
                    return head;
                }
                tail = tail.next;
                cnt--;
            }
            //cnt=1
            ListNode childProblemNode = tail.next;
            ListNode newHead = reverse(head, tail);
            //翻转后head变成了尾结点
            head.next = reverseKGroup(childProblemNode, k);
            return newHead;
        }

        //翻转head到tail区间的链表，返回重构后的头节点
        ListNode reverse(ListNode head, ListNode tail) {
            if (head == tail) {
                return tail;
            }

            ListNode newHead = reverse(head.next, tail);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}