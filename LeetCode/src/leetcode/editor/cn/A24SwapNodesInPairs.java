package leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 655 👎 0

public class A24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new A24SwapNodesInPairs().new Solution();
        // TO TEST
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
        public ListNode swapPairs(ListNode head) {
            // 递归
            //本层处理
            if (head == null || head.next == null) return head;
            ListNode newHead = head.next;

            head.next = swapPairs(newHead.next);

            //从下层回溯后
            newHead.next = head;
            return newHead;


            //三指针
//            if (head == null || head.next == null) return head;
//            ListNode pre = head;
//            ListNode cur = head.next;
//            ListNode res = head.next;
//
//            //如果链表长度为2
//            if (cur.next == null) {
//                cur.next = pre;
//                pre.next = null;
//                return cur;
//            }
//
//            ListNode des = head.next.next;
//            boolean flag = false;   //判定链表长度是否为奇数
//            while (des != null) {
//                cur.next = pre;
//                if (des.next != null) {
//                    pre.next = des.next;
//                    //三指针右移2位
//                    pre = des;
//                    cur = pre.next;
//                    des = cur.next;
//                } else {
//                    flag = true;  //说明链表长度为奇数
//                    pre.next = des;
//                    break;
//                }
//
//
//            }
//            if (!flag) {
//                cur.next = pre;
//                pre.next = null;
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}