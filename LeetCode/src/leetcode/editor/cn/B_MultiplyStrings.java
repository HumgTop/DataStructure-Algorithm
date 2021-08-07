package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


public class B_MultiplyStrings {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.multiply("98", "9"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            //竖式加减法
            //进位
            StringBuilder res = new StringBuilder();
            Queue<Integer> queue1 = new LinkedList<>(); //存放每一层的结果
            Queue<Integer> queue2 = new LinkedList<>(); //累加结果
            for (int i = 0; i < num1.length(); i++) {
                //num1属于竖式的下面
                int add = 0;
                int below = num1.charAt(num1.length() - i - 1) - '0';
                queue1.clear();
                for (int j = 0; j < num2.length(); j++) {
                    int upper = num2.charAt(num2.length() - j - 1) - '0';
                    int temp = below * upper + add;
                    add = temp / 10;
                    temp %= 10;
                    queue1.add(temp);
                }
                if (add != 0) {
                    queue1.add(add);
                }
                //完成一层竖式相乘的计算
                if (queue2.isEmpty()) {
                    queue2 = new LinkedList<>(queue1);
                    continue;
                }
                int size = queue2.size();
                for (int m = 0; m < i; m++) {
                    queue2.add(queue2.remove());
                }
                int add2 = 0;
                //重合部分竖式相加
                for (int k = 0; k < size - i; k++) {
                    int a = queue2.remove();
                    int b = 0;
                    if (!queue1.isEmpty()) {
                        b = queue1.remove();
                    }
                    int temp2 = a + b + add2;
                    add2 = temp2 / 10;
                    queue2.add(temp2 % 10);
                }
                //添加非重合部分
                while (!queue1.isEmpty()) {
                    int temp3 = queue1.remove();
                    temp3 = temp3 + add2;
                    queue2.add(temp3 % 10);
                    add2 = temp3 / 10;
                }
                if (add2 != 0) {
                    queue2.add(add2);
                }
            }


            while (!queue2.isEmpty()) {
                res.append(queue2.remove());
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}