package leetcode.editor.cn;


public class B_ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 1) return 1;
            if (n < 0) return 1.0 / recur(x, -(long) n);
            return recur(x, n);
        }

        //返回x的n次幂结果
        double recur(double x, long n) {
            if (n == 0) return 1;
            //如果n是奇数
            if ((n & 1) == 1) {
                return x * recur(x, n - 1);
            } else {
                double temp = recur(x, n / 2);
                return temp * temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}