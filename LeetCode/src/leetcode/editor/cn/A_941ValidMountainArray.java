package leetcode.editor.cn;

public class A_941ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new A_941ValidMountainArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length < 3) return false;
            if (A[0] > A[1]) return false;

            //至少有A[0]<A[1]
            for (int i = 1; i < A.length; i++) {
                //找到降序序列的起始位置
                if (A[i - 1] > A[i]) {
                    for (int j = i; j < A.length - 1; j++) {
                        //如果后续序列不是单调降序，返回false
                        if (A[j] <= A[j + 1]) return false;
                    }
                    //如果是单调降序返回TRUE
                    return true;
                }
            }
            //如果是升序序列
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}