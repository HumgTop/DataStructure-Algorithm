package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;


public class B_SortAnArray {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            //归并排序
            buildMaxHeap(nums);
            int len = nums.length;
            for (int i = len; i > 1; i--) {
                swap(nums, 0, i - 1);   //确定一个元素的顺序
                heapify(nums, 0, i - 1);
            }
            return nums;
        }

        //第一次初始化最大堆
        void buildMaxHeap(int[] nums) {
            //从最后一个非叶节点倒序调整
            int idx = nums.length / 2 - 1;
            for (int i = idx; i >= 0; i--) {
                heapify(nums, i, nums.length);
            }
        }

        void heapify(int[] nums, int idx, int len) {
            int temp = nums[idx];
            //类似插入排序，将节点idx下沉到合适的位置
            while (idx * 2 + 1 < len) {
                int childIdx = idx * 2 + 1;
                if (childIdx + 1 < len && nums[childIdx + 1] > nums[childIdx]) {
                    childIdx++;
                }
                if (temp < nums[childIdx]) {
                    nums[idx] = nums[childIdx];
                    idx = childIdx;
                } else break;
            }
            nums[idx] = temp;
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}