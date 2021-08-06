package leetcode.editor.cn;

public class B_RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {

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
        //对该节点和之后的元素进行去重，返回去重后的链表
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode cur = head.next;
            //如果head本身重复，丢弃head
            if (cur.val == head.val) {
                while (cur != null && cur.val == head.val) {
                    cur = cur.next;
                }
                //此时cur==null或者cur的值不等于head
                return deleteDuplicates(cur);
            }

            //head不重复，保留head
            head.next = deleteDuplicates(cur);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}