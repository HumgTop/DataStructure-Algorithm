package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Queue;

public class A649_Dota2Senate {
    public static void main(String[] args) {

        Solution solution = new A649_Dota2Senate().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String predictPartyVictory(String senate) {
            int n = senate.length();
            Queue<Integer> radiant = new LinkedList<>();
            Queue<Integer> dire = new LinkedList<>();
            //遍历字符串，将天辉和夜魇的索引入列
            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R') radiant.add(i);
                else dire.add(i);
            }

            //对radiant和dire依次出列，索引值较小的重新入列，较大的抛弃
            while (!radiant.isEmpty() && !dire.isEmpty()) {
                int curRadiant = radiant.remove();
                int curDire = dire.remove();
                if (curRadiant < curDire) radiant.add(curRadiant + n);      //+n表示参加下一轮的投票
                else dire.add(curDire + n);
            }

            return radiant.isEmpty() ? "Dire" : "Radiant";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}