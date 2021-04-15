package leetcode.editor.cn;


public class B_FanZhuanLianBiaoLcof {
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

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode newHead = reverseList(head.next);
            head.next.next = head;  //让本层节点的后一个节点指向本节点
            head.next = null; //本层节点指向null

            return newHead;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}