package leetcode.editor.cn;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 689 👎 0

import java.util.function.BiConsumer;

public class A75SortColors {
    public static void main(String[] args) {
        Solution solution = new A75SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            BiConsumer<Integer, Integer> swap = (i, j) -> {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            };

            int i = 0, cur = 0, j = nums.length - 1;
            //i指向0区域的尾部，j指向2区域的头部，cur为当前遍历元素
            while (cur <= j) {
                if (nums[cur] == 0) swap.accept(i++, cur++);    //交换前的nums[i]必然是1
                else if (nums[cur] == 2) swap.accept(j--, cur); //此处cur不能移动，因为交换前的nums[j]可能为0
                    // 如果为0还需再次进行交换
                else cur++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}