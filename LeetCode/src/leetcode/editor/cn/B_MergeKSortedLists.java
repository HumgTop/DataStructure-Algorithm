package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;


public class B_MergeKSortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            return merge(lists, 0, lists.length - 1);
        }

        /**
         * 合并[left:right]区间内的链表，并返回头节点
         *
         * @param lists
         * @param left
         * @param right
         * @return
         */
        ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            //分治：分区后进行子递归直到left==right才开始处理
            int mid = (left + right) >> 1;
            return merge2ListNode(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        ListNode merge2ListNode(ListNode node1, ListNode node2) {
            ListNode dummyHead = new ListNode();
            ListNode cur = dummyHead;
            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    cur.next = node1;
                    node1 = node1.next;
                } else {
                    cur.next = node2;
                    node2 = node2.next;
                }
                cur = cur.next;
            }
            while (node1 != null) {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
            }

            while (node2 != null) {
                cur.next = node2;
                node2 = node2.next;
                cur = cur.next;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}