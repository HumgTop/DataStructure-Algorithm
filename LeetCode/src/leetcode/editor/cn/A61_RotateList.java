package leetcode.editor.cn;


import java.util.List;

public class A61_RotateList {
    public static void main(String[] args) {

        Solution solution = new A61_RotateList().new Solution();

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
     * 快慢指针：fast先走k步
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) return head;

            ListNode fast = new ListNode();
            fast.next = head;
            // fast先走k步
            for (int i = 0; i < k; i++) {
                if (fast.next != null) fast = fast.next;
                else {
                    int trueK = k % i;
                    System.out.println(trueK);
                    if (trueK == 0) return head;    //旋转后没有变化
                    return rotateRight(head, trueK);
                }
            }

            ListNode slow = new ListNode();
            slow.next = head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if (slow.next == head) return head; //如果slow没有移动，则无需分割（如[1],1这种情况）
            //将slow与slow.next分割
            ListNode dummyHead = new ListNode();
            dummyHead.next = slow.next;
            slow.next = null;

            //连接fast和head
            fast.next = head;

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}