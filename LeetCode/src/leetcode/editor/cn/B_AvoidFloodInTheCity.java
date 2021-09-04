package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class B_AvoidFloodInTheCity {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] avoidFlood(int[] rains) {
            int[] res = new int[rains.length];
            Arrays.fill(res, 1);

            TreeSet<Integer> sunShine = new TreeSet<>();    //记录晴天的日期
            HashMap<Integer, Integer> map = new HashMap<>();    //key为湖泊序号，value为该湖泊上次下雨的日期

            for (int i = 0; i < rains.length; i++) {
                if (rains[i] == 0) {
                    sunShine.add(i);    //第i天是晴天
                } else {
                    res[i] = -1;    //下雨天置-1
                    if (map.containsKey(rains[i])) {
                        //如果该湖泊之前已经下过雨
                        Integer date = map.get(rains[i]);
                        //在sunShine中找到date之后的晴天，放空此湖泊的水
                        Integer higher = sunShine.higher(date);
                        if (higher == null) {
                            //无法阻止洪水
                            return new int[]{};
                        }
                        //该晴天防水的湖泊序号
                        res[higher] = rains[i];
                        //更新sunShine和map
                        sunShine.remove(higher);
                    }

                    map.put(rains[i], i);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}