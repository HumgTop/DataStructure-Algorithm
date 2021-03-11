package leetcode.editor.cn;


public class B_ShanChuLianBiaoDeJieDianLcof {
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
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val) return head.next;
            recur(head, val);
            return head;
        }

        void recur(ListNode cur, int val) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                return;
            }
            recur(cur.next, val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}