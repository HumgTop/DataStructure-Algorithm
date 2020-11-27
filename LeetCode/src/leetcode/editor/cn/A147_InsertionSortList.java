package leetcode.editor.cn;


public class A147_InsertionSortList {
    public static void main(String[] args) {

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
        public ListNode insertionSortList(ListNode head) {
            if (head == null) return null;

            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode cur = head;    //cur指向已排序链表的尾节点
            while (cur.next != null) {
                //本轮处理的待排序节点
                ListNode temp = cur.next;
                //将cur.next指向下个待排序节点
                cur.next = temp.next;
                //p指针用于在已排序链表中找到cur.next的位置
                ListNode p = dummyHead;
                while (p != cur && temp.val > p.next.val) {
                    p = p.next;
                }
                //temp.val<p.next.val或者p==cur,说明temp应插入p和p.next之间
                temp.next = p.next;
                p.next = temp;
                if (p == cur) cur = temp;   //如果temp插入了有序表尾部，更新cur节点
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}