package leetcode.editor.cn;

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 61 👎 0

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String S) {
            //反转指针
            StringBuilder sb = new StringBuilder();
            int j = S.length() - 1;
            for (int i = 0; i < S.length(); i++) {
                //如果当前字符是字母，则添加j指针（字母）到sb
                if (Character.isLetter(S.charAt(i))) {
                    //如果当前j指针不是字母，j持续左移
                    while (!Character.isLetter(S.charAt(j))) {
                        j--;
                    }
                    sb.append(S.charAt(j--));
                } else {
                    //如果是符号，则直接添加到sb中
                    sb.append(S.charAt(i));
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}