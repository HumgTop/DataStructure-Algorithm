package leetcode.editor.cn;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class A_31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new A_31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        BiConsumer<Integer, Integer> swap;

        public void nextPermutation(int[] nums) {
            swap = (id1, id2) -> {
                int temp = nums[id1];
                nums[id1] = nums[id2];
                nums[id2] = temp;
            };

            //从nums尾部向头部遍历，找到第一个波峰（如果没有波峰，说明此排列已是最大排列）
            int id = 0;

            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    id = i;
                    break;
                }
            }

            if (id == 0) {
                //如果是全降序排列，改为升序即可
                Arrays.sort(nums);
                return;
            }

            int minVal = Integer.MAX_VALUE; // 记录降序序列中的最小值
            int minId = 0;
            //在[id:]区间内找到大于nums[id-1]的最小元素
            for (int i = id; i < nums.length; i++) {
                if (nums[i] > nums[id - 1] && nums[i] < minVal) {
                    minVal = nums[i];
                    minId = i;
                }
            }

            if (id == nums.length - 1) swap.accept(minId, id - 1);
            else {
                //交换minId和id-1位置的元素
                swap.accept(minId, id - 1);
                //将[id,nums.length-1]的元素升序排列
//                insertionSort(nums, id);
                quickSort(nums, id, nums.length - 1);
            }
        }

        //插入排序
        void insertionSort(int[] nums, int left) {
            int id = left + 1;  //无序表的第一个元素
            while (id < nums.length) {
                int insertVal = nums[id];
                int insertId = id - 1;
                while (insertId >= left && insertVal < nums[insertId]) {
                    nums[insertId + 1] = nums[insertId];
                    insertId--;
                }
                nums[insertId + 1] = insertVal;

                id++;
            }
        }

        //快速排序
        void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int pivotID = partition(nums, left, right);

                quickSort(nums, left, pivotID - 1);
                quickSort(nums, pivotID + 1, right);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int pivotID = left;
            int lp = left + 1, rp = lp;
            while (rp <= right) {
                if (nums[rp] < pivot) swap.accept(rp++, lp++);
                else rp++;
            }

            swap.accept(pivotID, lp - 1);
            return lp - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}