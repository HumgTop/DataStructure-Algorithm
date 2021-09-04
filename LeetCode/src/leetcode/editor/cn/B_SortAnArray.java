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
            //建立最大堆：根节点应该大于左右孩子的值
            buildMaxHeap(nums);
            for (int i = 0; i < nums.length; i++) {
                swap(nums, 0, nums.length - 1 - i);
                heapify(nums, 0, nums.length - 1 - i);
            }
            return nums;
        }

        void buildMaxHeap(int[] nums) {
            //从最后一个非叶节点开始处理
            int idx = nums.length / 2 - 1;
            for (int i = idx; i >= 0; i--) {
                heapify(nums, i, nums.length);
            }
        }

        void heapify(int[] nums, int idx, int len) {
            int temp = nums[idx];
            int childIdx;
            while ((childIdx = idx * 2 + 1) < len) {
                if (childIdx + 1 < len && nums[childIdx + 1] > nums[childIdx]) {
                    childIdx++;
                }
                if (temp < nums[childIdx]) {
                    nums[idx] = nums[childIdx];
                    idx = childIdx;
                }
                //temp>nums[childIdx]
                else break;
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