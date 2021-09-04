package leetcode.editor.cn;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_ThreeSum {
    public static void main(String[] args) {

=======
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class B_ThreeSum {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(LeetCodeUtils.get1dArr("[0,0,0]")));
>>>>>>> origin/master
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
<<<<<<< HEAD
            Arrays.sort(nums);
            if (nums.length < 3 || nums[0] > 0) return new ArrayList<>();

            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();

            //i指针指向a
            for (int i = 0; i < n - 2; i++) {
                if (nums[i] > 0) {
                    return res;
                }
                //避免重复解
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int j = i + 1;  //指向b
                int k = n - 1;  //指向c

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[++j] == nums[j - 1]) ;   //结束循环时,nums[j]!=nums[j-1]
                        while (j < k && nums[--k] == nums[k + 1]) ;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        //移动j指针，增大和
                        while (j < k && nums[++j] == nums[j - 1]) ;
                    } else {
                        //移动k指针，减小和
                        while (j < k && nums[--k] == nums[k + 1]) ;
                    }
=======
            if (nums.length < 3) return new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n - 2; i++) {
                if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) continue;

                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        level.clear();
                        Collections.addAll(level, nums[i], nums[j], nums[k]);
                        res.add(new ArrayList<>(level));
                        //移动j和k，避免重复解
                        int temp1 = nums[j];
                        int temp2 = nums[k];
                        while (j < k && nums[++j] == temp1) ;
                        while (j < k && nums[--k] == temp2) ;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        //移动j指针，使和变大
                        j++;
                    } else k--;
>>>>>>> origin/master
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

<<<<<<< HEAD
=======

>>>>>>> origin/master
}