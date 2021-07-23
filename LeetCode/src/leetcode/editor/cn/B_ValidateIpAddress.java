package leetcode.editor.cn;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class B_ValidateIpAddress {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String validIPAddress(String IP) {
            if (IP == null) return "Neither";

            String chunkV4 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
            String regexV4 = "(" + chunkV4 + "\\.){3}" + chunkV4;

            String chunkV6 = "([0-9A-Fa-f]{1,4})";
            String regexV6 = "(" + chunkV6 + "\\:){7}" + chunkV6;

            String res = "Neither";
            if (IP.contains(".")) {
                Pattern pattern = Pattern.compile(regexV4);
                Matcher matcher = pattern.matcher(IP);
                return matcher.matches() ? res = "IPv4" : res;
            } else {
                Pattern pattern = Pattern.compile(regexV6);
                return pattern.matcher(IP).matches() ? res = "IPv6" : res;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}