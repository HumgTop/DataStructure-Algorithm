package leetcode.editor.cn;


public class A164_MaximumGap {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //只需要知道该桶的最大最小值即可
    class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    class Solution {
        public int maximumGap(int[] nums) {
            int n = nums.length;
            if (n < 2) return 0;

            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int num : nums) {
                max = Math.max(num, max);
                min = Math.min(num, min);
            }

            //计算桶大小
            int gap = Math.max((max - min) / (n - 1), 1);   //桶大小最小为1
            System.out.println(gap);
            //桶数量
            int cnt = (max - min) / gap + 1;
            Bucket[] buckets = new Bucket[cnt];

            for (int num : nums) {
                int bID = (num - min) / gap;   //该元素所在的桶ID
                //如果该桶还未创建，创建该桶
                if (buckets[bID] == null) {
                    buckets[bID] = new Bucket();
                }
                //实时维护该桶的最大和最小值
                buckets[bID].min = Math.min(buckets[bID].min, num);
                buckets[bID].max = Math.max(buckets[bID].max, num);
            }

            int previousMax = Integer.MAX_VALUE, maxGap = 0;
            for (int i = 0; i < cnt; i++) {
                //如果该桶不为空，且不是第一个桶
                if (buckets[i] != null && previousMax != Integer.MAX_VALUE) {
                    maxGap = Math.max(maxGap, buckets[i].min - previousMax);
                }
                //更新previousMax
                if (buckets[i] != null) {
                    previousMax = buckets[i].max;
                }
            }

            return maxGap;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}