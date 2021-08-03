package leetcode.editor.cn;


public class B_LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public static void main(String[] args) {


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            while (curA != curB) {
                curA = curA == null ? headB : curA.next;
                curB = curB == null ? headA : curB.next;
            }

            return curA;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}