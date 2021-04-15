package leetcode.editor.cn;


import java.util.ArrayDeque;

public class B_CongWeiDaoTouDaYinLianBiaoLcof {
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
        int[] res;
        int idx = 0;

        public int[] reversePrint(ListNode head) {
            recur(head);
            return res;
        }

        //在回溯阶段添加节点值到res中
        void recur(ListNode cur) {
            if (cur == null) {
                res = new int[idx];
                idx = 0;
                return;
            }
            idx++;  //记录节点有多少个
            recur(cur.next);
            res[idx++] = cur.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}