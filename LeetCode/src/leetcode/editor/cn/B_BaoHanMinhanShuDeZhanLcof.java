package leetcode.editor.cn;


public class B_BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        MinStack minStack = new B_BaoHanMinhanShuDeZhanLcof().new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.min();
        minStack.push(-2147483648);
        minStack.top();
        minStack.min();
        minStack.pop();
        minStack.min();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        int minVal = Integer.MAX_VALUE;
        ListNode cur;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            cur = new ListNode(-1);
        }

        public void push(int x) {
            if (x < minVal) minVal = x; //维护更新最小值

            ListNode newNode = new ListNode(x);
            newNode.minVal = minVal;
            cur.next = newNode;
            newNode.pre = cur;
            cur = newNode;
        }

        public void pop() {
            cur = cur.pre;
            cur.next = null;
        }

        public int top() {
            System.out.println(cur.val);
            return cur.val;

        }

        public int min() {
            System.out.println(cur.minVal);
            return cur.minVal;
        }
    }

    class ListNode {
        int val;
        ListNode pre;
        ListNode next;
        int minVal; //从栈底到当前元素的最小值

        public ListNode(int val) {
            this.val = val;
        }

    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)


}