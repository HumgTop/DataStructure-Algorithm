package leetcode.editor.cn;


public class B_ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res = res ^ num;
            }
            //此时res为a^b的值（a和b为数组中只出现1次的数）
            int div = 1;
            //找到二进制res中最低位1（利用a和b在此位值不同的特点，对数组进行分组）
            while ((div & res) == 0) {
                div <<= 1;  //左移1位
            }

            int a = 0;
            int b = 0;
            for (int num : nums) {
                //分组判断
                if ((num & div) == 0) {
                    a ^= num;
                } else b ^= num;
            }

            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}