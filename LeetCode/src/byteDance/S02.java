package byteDance;

/**
 * @Autor HumgTop
 * @Date 2021/9/3 16:25
 * @Version 1.0
 * 36进制加法
 */
public class S02 {
    public static void main(String[] args) {
        System.out.println(addStrings("1b", "2x"));     //答案为48
    }

    static String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int i = ch1.length - 1, j = ch2.length - 1;
        int add = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0 || add != 0) {
            //转换为10进制计算
            int val1 = i >= 0 ? getInt(ch1[i]) : 0;
            int val2 = j >= 0 ? getInt(ch2[j]) : 0;
            int temp = val1 + val2 + add;
            //结果转换为36进制存入
            res.append(getChar(temp % 36));
            add = temp / 36;
            i--;
            j--;
        }

        return res.reverse().toString();
    }

    //36进制字符转10进制int
    static int getInt(char ch) {
        if ('0' <= ch & ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'a' + 10;
        }
    }

    //10进制int转36进制char
    static char getChar(int n) {
        if (0 <= n && n <= 9) {
            return (char) ('0' + n);
        } else {
            return (char) ('a' + n - 10);
        }
    }
}
