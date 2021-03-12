package leetcode.editor.cn;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B_BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new B_BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        System.out.println(solution.isNumber("-1E-16"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public boolean isNumber(String s) {
            s = s.trim();
            //排除三种情况。  空串，e前没有数字，只有.
            String regex = "\\s*|([+-]?\\.?[eE][\\s\\S]*)|([+-]?\\.)";
            if (s.matches(regex)) return false;
            //对不是特殊情况的字符串，进行正则匹配
            regex = "(([+-])?\\d*\\.?\\d*)([eE][+-]?\\d+)?";
            return s.matches(regex);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}