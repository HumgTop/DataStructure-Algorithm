package leetcode.editor.cn;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class B_FanZhuanDanCiShunXuLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            //双指针，i和j指向单词的边界。每确定一个边界就添加一次到sb中
            StringBuilder sb = new StringBuilder();
            s = s.trim();   //去除首尾空格
            int i = s.length() - 1, j = i;
            while (i >= 0) {
                if (s.charAt(i) != ' ') i--;
                else {
                    //此时i指向空格
                    sb.append(s, i + 1, j + 1).append(" ");
                    while (i >= 0 && s.charAt(i) == ' ') {
                        i--;
                    }
                    //此处i指向字符，或者i为-1
                    j = i;
                }
            }
            if (j != i) {
                sb.append(s, i + 1, j + 1).append(" ");
            }
            return sb.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    @Test
    public void test() {

    }
}