package leetcode.editor.cn;


public class A204_CountPrimes {
    public static void main(String[] args) {

        Solution solution = new A204_CountPrimes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int cnt = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }
            return cnt;
        }

        private boolean isPrime(int num) {
            int max = (int) Math.sqrt(num);
            for (int i = 2; i <= max; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}