package leetcode.editor.cn;
//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 93 👎 0

public class A925LongPressedName {
    public static void main(String[] args) {
        Solution solution = new A925LongPressedName().new Solution();
        System.out.println(solution.isLongPressedName("", ""));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            name += "0";
            int index = -1;
            int count = 1;
            int i = 0;
            //name中连续出现字符的数目要小于typed中的数目
            for (i = 0; i < name.length() - 1; i++) {
                char ch = name.charAt(i);
                if (ch == name.charAt(i + 1)) {
                    count++;    //记录ch出现的次数
                    continue;
                }
                //如果typed已经匹配完，name还有剩余字符说明不匹配
                if (index == typed.length() - 1) {
                    return false;
                }
                //待匹配字符
                while (index < typed.length() - 1) {
                    index++;
                    char ch1 = typed.charAt(index);
                    if (ch1 == ch) {
                        count--;
                    } else if (count <= 0) {
                        index--;
                        count = 1;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            //如果typed没有匹配完毕，返回false
            return index == typed.length() - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}