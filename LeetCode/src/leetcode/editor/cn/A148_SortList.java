package leetcode.editor.cn;


public class A148_SortList {
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
        /**
         * @param head
         * @return 返回排好序的链表头节点
         */
        public ListNode sortList(ListNode head) {
            //终止条件：切分的链表长度为1时，返回head开始回溯
            if (head == null || head.next == null) return head;

            ListNode slow = head;
            ListNode fast = head;
            //通过快慢指针找到链表中点进行cut
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //奇数个节点，slow指向中间节点；偶数个节点，slow指向中间左侧的节点
            ListNode mid = slow.next;
            //将链表cut
            slow.next = null;

            ListNode left = sortList(head); //排好序的左侧链表头节点
            ListNode right = sortList(mid); //排好序的右侧链表头节点

            //对left和right进行归并排序
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                } else {
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }
            }
            //当left和right其中一个链表遍历结束时，将未完成遍历的链表头节点加入到dummyHead的尾部
            cur.next = left == null ? right : left;

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}