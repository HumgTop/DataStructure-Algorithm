package leetcode.editor.cn;


public class B_LinkedListCycleIi {
    public static void main(String[] args) {


    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            //快慢指针相遇时，从头节点出发第三个指针p，则p与slow在入环点相遇
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) fast = fast.next.next;
                else return null;

                //如果快慢指针相遇
                if (fast == slow) {
                    ListNode p = head;
                    while (p != slow) {
                        p = p.next;
                        slow = slow.next;
                    }
                    return p;
                }
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}