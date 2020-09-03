package common_Algorithm;

import org.junit.Test;

import java.util.*;

/**
 * 贪心算法
 */
public class No05_Greedy_Algorithm {
    public static void main(String[] args) {
        //创建广播电台map集合（key为电台名，value为覆盖地区）
        Map<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> cities1 = new HashSet<>(Arrays.asList("北京", "上海", "天津"));
        HashSet<String> cities2 = new HashSet<>(Arrays.asList("广州", "北京", "深圳"));
        HashSet<String> cities3 = new HashSet<>(Arrays.asList("成都", "上海", "杭州"));
        HashSet<String> cities4 = new HashSet<>(Arrays.asList("上海", "天津"));
        HashSet<String> cities5 = new HashSet<>(Arrays.asList("杭州", "大连"));

        map.put("k1", cities1);
        map.put("k2", cities2);
        map.put("k3", cities3);
        map.put("k4", cities4);
        map.put("k5", cities5);

        HashSet<String> uncoverAreas = new HashSet<>(Arrays.asList("北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连"));

        //存放已选择的电台集合
        ArrayList<String> selects = new ArrayList<>();
        //存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义maxKey，保存一次遍历过程中，能够覆盖最大未覆盖地区对应的电台的key
        //如果maxKey不为null，则会加入到selects
        String maxKey = null;
        Set<String> keySet = map.keySet();
        while (uncoverAreas.size() != 0) {
            for (String key : keySet) {
                tempSet.clear();
                HashSet<String> cities = map.get(key);  //当前电台可覆盖的区域
                //加入都temp中
                tempSet.addAll(cities);
                //** 求出两者的交集，并将交集重新赋给tempSet。此时tempSet.size()表明了该电台能实际增加的覆盖地区
                tempSet.retainAll(uncoverAreas);

                //** 贪心算法核心
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > map.get(maxKey).size())) {
                    //如果当前key能增加实际覆盖地区，且比maxKey的效果更好，则更新maxKey
                    maxKey = key;
                }
            }
            //如果maxKey不为空
            if (maxKey != null) {
                selects.add(maxKey);
                uncoverAreas.removeAll(map.get(maxKey));
                maxKey = null;
            }
        }
        System.out.println(selects);
    }

    /**
     * 复习
     *
     * @param map          key为电台名，value为该电台可覆盖区域
     * @param uncoverAreas
     * @return
     */
    public static List<String> greedy(Map<String, HashSet<String>> map, Set<String> uncoverAreas) {
        ArrayList<String> selects = new ArrayList<>();
        //定义maxKey，保存一次遍历过程中，能够覆实际增加覆盖地区对应的电台的key
        String maxKey = null;
        ArrayList<String> temp = new ArrayList<>();

        while (uncoverAreas.size() > 0) {
            for (String key : map.keySet()) {
                temp.clear();
                HashSet<String> cover = map.get(key);   //当前电台的可覆盖区域
                temp.addAll(cover);
                //** 求出两者的交集，并将交集重新赋给tempSet。此时tempSet.size()表明了该电台能实际增加的覆盖地区
                temp.retainAll(uncoverAreas);
                //此时temp存储的是实际增加的可覆盖城市

                //*** 贪心算法核心
                if (temp.size() > 0 && (maxKey == null || temp.size() > map.get(maxKey).size())) {
                    //如果当前key可以增加实际覆盖地区，且比maxKey覆盖的所有地区还要多，则更新maxKey
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                uncoverAreas.removeAll(map.get(maxKey));
                maxKey = null;
            }
        }
        return selects;
    }

    @Test
    public void greedyTest() {
        //创建广播电台map集合（key为电台名，value为覆盖地区）
        Map<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> cities1 = new HashSet<>(Arrays.asList("北京", "上海", "天津"));
        HashSet<String> cities2 = new HashSet<>(Arrays.asList("广州", "北京", "深圳"));
        HashSet<String> cities3 = new HashSet<>(Arrays.asList("成都", "上海", "杭州"));
        HashSet<String> cities4 = new HashSet<>(Arrays.asList("上海", "天津"));
        HashSet<String> cities5 = new HashSet<>(Arrays.asList("杭州", "大连"));

        map.put("k1", cities1);
        map.put("k2", cities2);
        map.put("k3", cities3);
        map.put("k4", cities4);
        map.put("k5", cities5);

        HashSet<String> uncoverAreas = new HashSet<>(Arrays.asList("北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连"));

        List<String> select = greedy(map, uncoverAreas);
        System.out.println(select);
    }
}
