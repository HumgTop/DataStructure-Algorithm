package leetcode.editor.cn;

import org.junit.Test;


public class B_RemoveDuplicatesFromSortedListIi {
    @Test
    public void test() {
        Solution solution = new Solution();

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
        //在回溯过程中，向上返回子链表
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;

            if (head.val != head.next.val) {
                //无需删除操作向下递归
                head.next = deleteDuplicates(head.next);
                return head;
            } else {
                //需要删除重复值的节点（跳过这些节点，不进行递归操作）
                ListNode temp = head.next;
                while (temp != null && temp.val == head.val) {
                    temp = temp.next;
                }
                //此时temp==null或者temp已经指向非重复值节点区域
                return deleteDuplicates(temp);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}