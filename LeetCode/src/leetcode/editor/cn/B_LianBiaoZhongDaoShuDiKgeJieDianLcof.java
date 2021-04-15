package leetcode.editor.cn;


public class B_LianBiaoZhongDaoShuDiKgeJieDianLcof {
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
        public ListNode getKthFromEnd(ListNode head, int k) {
            //快慢指针法
            //fast先走k步
            ListNode fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            ListNode slow = head;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}