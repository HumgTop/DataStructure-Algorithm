package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new A_23MergeKSortedLists().new Solution();
        // TO TEST
        //[1,3][2,4]
        ListNode node2 = new ListNode(-1);
        ListNode node1 = new ListNode(2, node2);

        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(1, node4);
        ListNode node = solution.mergeKLists(new ListNode[]{node1, node3});
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static public class ListNode {
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

            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((Comparator.comparingInt(node -> node.val)));
            for (ListNode node : lists) {
                if (node != null) {
                    minHeap.add(node);
                }
            }

            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;

            while (!minHeap.isEmpty()) {
                tail.next = minHeap.remove();
                tail = tail.next;
                if (tail.next != null) minHeap.add(tail.next);
            }

            return dummyHead.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}