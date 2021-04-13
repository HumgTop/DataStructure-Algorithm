package leetcode.editor.cn;


public class B_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new B_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        int res = solution.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            //滑动窗口：双指针模拟窗口，出现重复元素时左指针右移，直到排除重复元素
            boolean[] appear = new boolean[128];
            int l = 0, r = 0;
            char[] chars = s.toCharArray();
            int res = 1;

            while (r < s.length()) {
                int idx = chars[r];
                if (!appear[idx]) {
                    appear[idx] = true; //标记该字符已出现
                } else {
                    res = Math.max(r - l, res);
                    //左指针右移，直到排除重复元素
                    while (chars[l] != chars[r]) {
                        appear[chars[l]] = false;  //标记未出现
                        l++;
                    }
                    l++;
                }
                r++;
            }

            return Math.max(r - l, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}