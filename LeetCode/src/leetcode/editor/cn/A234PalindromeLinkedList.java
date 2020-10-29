package leetcode.editor.cn;
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 681 👎 0

public class A234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new A234PalindromeLinkedList().new Solution();
        // TO TEST
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
        public boolean isPalindrome(ListNode head) {
            //如果链表为空
            if (head == null) return true;
            //如果链表长度为1
            if (head.next == null) return true;
            //如果链表长度为2
            if (head.next.next == null) {
                return head.val == head.next.val;
            }

            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            //此时slow到达中点，从头部新出发一个节点
            ListNode ptr = head;
            assert slow.next != null;
            //反转右侧链表
            slow = reverse(slow.next);
            while (slow != null) {
                if (slow.val != ptr.val) return false;
                slow = slow.next;
                ptr = ptr.next;
            }
            return true;
        }

        //反转链表
        public ListNode reverse(ListNode head) {
            //迭代法
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            return pre;

            //递归法
//            if (head.next == null) return head;
//
//            ListNode newHead = reverse(head.next);
//
//            head.next.next = head;
//            head.next = null;
//
//            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}