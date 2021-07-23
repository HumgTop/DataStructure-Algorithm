package leetcode.editor.cn;

import org.junit.Test;


public class B_ReorderList {
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
        ListNode cur;   //cur指针向链表尾部移动
        ListNode temp;

        public void reorderList(ListNode head) {
            cur = head;
            recur(head);
        }

        //利用递归回溯的过程，node相当于向链表头部移动
        //返回-1表示重排结束，直接返回，不进行后续操作
        //返回0表示继续合并
        int recur(ListNode node) {
            if (node == null) {
                return 0;
            }

            int flag = recur(node.next);
            if (flag == -1) return -1;

            //到达末尾
            if (cur == node || cur.next == node) {
                node.next = null;
                return -1;
            }
            //链表重排
            temp = cur.next;    //记录副本
            cur.next = node;
            node.next = temp;
            cur = temp;
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}