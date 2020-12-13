package leetcode.editor.cn;


public class A92_ReverseLinkedListIi {
    public static void main(String[] args) {

        Solution solution = new A92_ReverseLinkedListIi().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        ListNode end;
        int m;
        int n;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            this.m = m;
            this.n = n;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode cur = dummyHead;
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
            }
            ListNode node1 = cur;   //主链表断点
            ListNode begin = cur.next;  //需要反转链表的头节点
            node1.next = reverse(begin, n - m); //主链表断点连接反转后的链表

            return dummyHead.next;
        }

        /**
         * @param step 反转的链表长度-1
         */
        ListNode reverse(ListNode node, int step) {
            if (step == 0) {
                end = node.next;
                return node;
            }
            ListNode head = reverse(node.next, step - 1);   //返回反转后的头节点
            //将当前节点加入到链表中
            node.next.next = node;
            node.next = end;   //回溯到顶部时，将尾节点连接到主链表
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}