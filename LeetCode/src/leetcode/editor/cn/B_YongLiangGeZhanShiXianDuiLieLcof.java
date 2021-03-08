package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class B_YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        Deque<Integer> A;
        Deque<Integer> B;

        public CQueue() {
            A = new ArrayDeque<>();
            B = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            A.addLast(value);
            //添加元素后，如果B为空，将所有元素转移到B中
            if (B.isEmpty()) {
                while (!A.isEmpty()) {
                    B.addLast(A.removeLast());
                }
            }
        }

        public int deleteHead() {
            //删除前，如果B为空，A不为空。则先将A中元素转移到B中再删除
            if (B.isEmpty() && !A.isEmpty()) {
                while (!A.isEmpty()) {
                    B.addLast(A.removeLast());
                }
            }
            return B.isEmpty() ? -1 : B.removeLast();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)


}