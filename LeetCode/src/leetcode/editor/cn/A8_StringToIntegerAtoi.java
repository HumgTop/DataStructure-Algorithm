package leetcode.editor.cn;

public class A8_StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new A8_StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi(" "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            if (s.length() == 0) return 0;

            StringBuilder sb = new StringBuilder();
            boolean blank = false;    //如果连续空格后，出现数字，将blank置为true
            int flag = 0; //标志位：为0表示正数，为1表示负数，为2表示为正数（首位字符出现+号）

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                //如果是空格直接跳过
                if (cur == ' ') {
                    if (blank) break;
                    continue;
                }
                //对第一个非空格字符进行判断
                if (!blank) {
                    if (cur == '-') {
                        flag = 1;   //符号位为负数
                        blank = true;
                        continue;
                    } else if (cur == '+') {
                        flag = 2;
                        blank = true;
                        continue;
                    }
                    //如果首位非数字，返回0
                    else if (!Character.isDigit(cur)) return 0;
                }
                blank = true;
                if (!Character.isDigit(cur)) break;
                sb.append(cur);
            }

            if (!blank) return 0;
            String temp = sb.toString();
            //如果首位出现了正负号，且temp长度为1
            if ((flag != 0 && temp.length() == 0)) return 0;

            int res;
            try {
                res = Integer.parseInt(temp);
                return flag == 1 ? -res : res;
            } catch (NumberFormatException e) {
                return flag == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}