package leetcode.editor.cn;

public class A832_FlippingAnImage {
    public static void main(String[] args) {
        Solution solution = new A832_FlippingAnImage().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            //双指针，对每一行逆序
            int len = A[0].length;
            for (int[] rows : A) {
                int left = 0;
                int right = len - 1;
                while (left < right) {
                    int temp = rows[left];
                    rows[left] = rows[right] == 0 ? 1 : 0;
                    rows[right] = temp == 0 ? 1 : 0;
                    left++;
                    right--;
                }
                if (left == right) rows[left] = Math.abs(rows[left] - 1);
            }

            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}