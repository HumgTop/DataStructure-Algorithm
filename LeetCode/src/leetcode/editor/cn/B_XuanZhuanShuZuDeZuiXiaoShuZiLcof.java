package leetcode.editor.cn;


public class B_XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new B_XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        solution.minArray(new int[]{3, 1, 3});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int len = numbers.length;
            //二分查找
            if (numbers[0] < numbers[len - 1]) return numbers[0];

            int left = 0, right = len - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                //说明此时left到right已经是有序数组
                if (numbers[left] < numbers[right]) return numbers[left];

                if (numbers[left] < numbers[mid]) {
                    left = mid + 1; //排除mid元素不是最小值
                }
                //当left元素==mid元素，无法判断最小值在mid的哪侧，只能排除left元素不是最小值
                else if (numbers[left] == numbers[mid]) {
                    left++;
                } else {    //当left元素>mid元素，最小元素肯定在mid的左侧（排除掉left元素）
                    left++;
                    right = mid;

                }
                mid = (left + right) / 2;
            }

            return numbers[mid];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}