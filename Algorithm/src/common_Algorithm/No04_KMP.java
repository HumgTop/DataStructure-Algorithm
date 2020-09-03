package common_Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * KMP算法
 */
public class No04_KMP {
    /**
     * 暴力匹配方法：与KMP算法形成对比
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = str1.length();
        int s2Len = str2.length();

        int s1Index = 0;
        int s2Index = 0;
        while (s1Index < s1Len && s2Index < s2Len) {
            if (s1[s1Index] == s2[s2Index]) {
                s1Index++;
                s2Index++;
            } else {
                s1Index = s1Index - (s2Index - 1);  //如果重新匹配 s1Index 后移一位
                s2Index = 0;
            }
        }
        if (s2Index == s2Len) {
            //说明匹配成功
            return s1Index - s2Index;   //匹配的字符串在str1中索引开始的位置
        } else {
            return -1;
        }
    }

    @Test
    public void violenceMatchTest() {
        int index = violenceMatch("合肥工业大学胡民港，安徽芜湖人", "胡民港");
        System.out.println(index);
    }

    /**
     * 获取目标字符串的部分匹配值
     *
     * @param dest
     * @return
     */
    public static int[] myKmpNext(String dest) {
        int length = dest.length();
        //创建一个next数组保存部分匹配值
        int[] next = new int[length];
        next[0] = 0;
        int nIndex = 1;

        //模式串的所有子串
        for (int i = 2; i <= length; i++) {
            ArrayList<String> preList = new ArrayList<>();
            ArrayList<String> suffixList = new ArrayList<>();

            String substring = dest.substring(0, i);
            //substring的长度为i
            //比对substring的前缀、后缀，将部分匹配值存入next[]
            for (int j = 1; j <= i - 1; j++) {
                String pre = substring.substring(0, j);
                preList.add(pre);
            }
            for (int j = i - 1; j >= 1; j--) {
                String suffix = substring.substring(j, i);
                suffixList.add(suffix);
            }
            //比对前缀、后缀集合，将最长的公共元素长度存入next中
            for (String str : preList) {
                if (suffixList.contains(str)) {
                    //** 前缀后缀集合共有最长元素的长度
                    next[nIndex] = str.length();
                }
            }
            nIndex++;
        }
        return next;
    }

    @Test
    public void myKmpNextTest() {
        String str = "AAAB";
        int[] next = myKmpNext(str);
        System.out.println(Arrays.toString(next));
    }

    /**
     * 网课demo
     * 获取目标字符串的最大公共前后缀长度值
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        int length = dest.length();
        //此处的next数组只是简化版，只对应 模式串子串 的最大公共前后缀长度值
        int[] next = new int[length];
        next[0] = 0;

        for (int i = 1, j = 0; i < length; i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                /*
                此过程相当于模式串的自我匹配
                当模式串（前缀）中在j 处的字符跟模式串（后缀）在i 处的字符匹配失配时
                下一步用next [j-1] 处的字符继续跟模式串（后缀）i 处的字符匹配
                （所以j=next[j-1]相当于模式串（前缀）向右移动 j - next[j-1] 位
                 */
                j = next[j - 1];    //一旦匹配中断重置指针j
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    @Test
    public void kmpNextTest() {
        String str = "ABCDABD";
        int[] next = kmpNext(str);
        System.out.println(Arrays.toString(next));
    }

    /**
     * KMP算法
     * 网课demo
     *
     * @param string
     * @param pattern
     * @param next
     * @return
     */
    public static int kmpSearch(String string, String pattern, int[] next) {
        int sIndex;
        int pIndex = 0;

        for (sIndex = 0; sIndex < string.length(); sIndex++) {
            //** 如果当前sIndex和pIndex指向的字符不匹配，对pIndex进行回溯，直到2指针指向的字符匹配
            while (pIndex > 0 && string.charAt(sIndex) != pattern.charAt(pIndex)) {
                pIndex = next[pIndex - 1];  //相当于模式串右移 pIndex-next[pIndex-1]位
            }

            if (string.charAt(sIndex) == pattern.charAt(pIndex)) {
                pIndex++;
            }

            if (pIndex == pattern.length()) {
                return sIndex - pIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String string = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        int[] next = kmpNext(pattern);
        int index = kmpSearch(string, pattern, next);
        System.out.println(index);
    }

    /**
     * 复习
     * 获取模式串的 next 数组
     * 2020年9月3日08:18:34
     *
     * @param pattern
     * @return
     */
    public static int[] kmpNextReview(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];
        next[0] = 0;

        for (int i = 1, j = 0; i < length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * 复习
     * KMP算法
     *
     * @param string
     * @param pattern
     * @param next
     * @return
     */
    public static int kmpReview(String string, String pattern, int[] next) {
        int sIndex;
        int pIndex = 0;

        for (sIndex = 0; sIndex < string.length(); sIndex++) {
            while (pIndex > 0 && string.charAt(sIndex) != pattern.charAt(pIndex)) {
                pIndex = next[pIndex - 1];    //相当于模式串右移pIndex-next[pIndex-1]位
            }
            if (string.charAt(sIndex) == pattern.charAt(pIndex)) {
                pIndex++;
            }
            if (pIndex == pattern.length()) {
                return sIndex - pIndex + 1;
            }
        }
        return -1;
    }

    @Test
    public void kmpTest() {
        String string = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        int[] next = kmpNextReview(pattern);
        int index = kmpReview(string, pattern, next);
        System.out.println(index);
    }
}
