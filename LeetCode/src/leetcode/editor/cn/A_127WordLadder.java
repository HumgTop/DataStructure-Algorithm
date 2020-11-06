package leetcode.editor.cn;

import java.util.*;

public class A_127WordLadder {
    public static void main(String[] args) {
        Solution solution = new A_127WordLadder().new Solution();
        // TO TEST
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(
                "hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"
        ));
        System.out.println(solution.ladderLength("hot", "dog", wordList));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            HashSet<String> used = new HashSet<>();

            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                level++;    //记录curWord的下一层的的层数

                for (int i = 0; i < size; i++) {
                    String curWord = queue.remove();
                    //修改curWord每个位置的字符，然后判断修改后的curWord是否在wordSet中且不在used中
                    char[] chars = curWord.toCharArray();
                    char temp;

                    for (int j = 0; j < curWord.length(); j++) {
                        temp = curWord.charAt(j);
                        String nextWord = "";
                        for (char k = 'a'; k <= 'z'; k++) {
                            if (k == temp) continue;
                            chars[j] = k;
                            nextWord = new String(chars);   //新建curWord可转换的单词

                            //如果nextWord在单词列表，且未使用
                            if (wordSet.contains(nextWord)) {
                                if (nextWord.equals(endWord)) return level;
                                if (!used.contains(nextWord)) {
                                    //添加到队列中
                                    queue.add(nextWord);
                                    //标记已访问
                                    used.add(nextWord);
                                }
                            }
                        }
                        //恢复修改的字符
                        chars[j] = temp;
                    }
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}