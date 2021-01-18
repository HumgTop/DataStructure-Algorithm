package leetcode.editor.cn;

import java.util.*;

public class A721_AccountsMerge {
    public static void main(String[] args) {
        Solution solution = new A721_AccountsMerge().new Solution();
        String[] a1 = {"David", "0", "1"};
        String[] a2 = {"David", "3", "4"};
        String[] a3 = {"David", "4", "5"};
        String[] a4 = {"David", "2", "3"};
        String[] a5 = {"David", "1", "2"};
        ArrayList<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList(a1));
        input.add(Arrays.asList(a2));
        input.add(Arrays.asList(a3));
        input.add(Arrays.asList(a4));
        input.add(Arrays.asList(a5));
        for (List<String> strings : solution.accountsMerge(input)) {
            System.out.println(strings);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] parent;  //parent[i]表示第i个account的父节点
        ArrayList<Set<String>> accountSet = new ArrayList<>();  //转为set，便于查询

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            List<List<String>> res = new ArrayList<>();
            //初始化parent根节点为其自身
            parent = new int[accounts.size()];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }


            HashMap<String, List<Integer>> accountNames = new HashMap<>();  //记录账户名相同的节点序号
            String[] names = new String[accounts.size()];
            for (int i = 0; i < accounts.size(); i++) {
                ArrayList<String> account = new ArrayList<>(accounts.get(i));

                names[i] = account.get(0);
                account.remove(0);  //去除账户名
                accountSet.add(new HashSet<>(account));

                if (accountNames.containsKey(names[i])) {
                    //遍历每个账户下的邮箱，判断该邮箱是否在其他账户下出现
                    for (Integer idx : accountNames.get(names[i])) {
                        Set<String> account2 = accountSet.get(idx);
                        for (String s : account) {
                            if (account2.contains(s)) {
                                //进行合并操作，更改根节点，合并i账户到idx的根节点
                                merge(i, idx);
                                break;
                            }
                        }
                    }
                    accountNames.get(names[i]).add(i);
                } else {    //该账户名第一次出现
                    accountNames.computeIfAbsent(names[i], key -> new ArrayList<>()).add(i);
                }

            }
            //遍历所有的根节点，将其集合按顺序添加到res中
            HashSet<Integer> roots = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                roots.add(find(i)); //！！此处find，因为可能有parent数组中指向父节点，并未指向根节点！！
                //合并当前节点的账户到根节点上
                accountSet.get(parent[i]).addAll(accountSet.get(i));
            }
            for (Integer rootIdx : roots) {
                ArrayList<String> list = new ArrayList<>(accountSet.get(rootIdx));
                Collections.sort(list);
                list.add(0, names[rootIdx]);
                res.add(list);
            }
            return res;
        }

        int find(int idx) {
            if (parent[idx] != idx) parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        void merge(int idx1, int idx2) {
            int root1 = find(idx1);
            int root2 = find(idx2);
            if (root1 != root2) parent[root1] = root2;  //合并根节点
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}