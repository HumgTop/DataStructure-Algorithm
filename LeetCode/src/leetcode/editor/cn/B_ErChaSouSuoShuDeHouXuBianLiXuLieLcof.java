package leetcode.editor.cn;


public class B_ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        /**
         * @param postorder
         * @param left      当前子树元素在数组中的索引范围
         * @param right
         * @return
         */
        boolean recur(int[] postorder, int left, int right) {
            if (left >= right) return true; //递归到单个元素，终止
            //p[right]为根节点（左子树的元素都小于根节点，右子树的元素都大于根节点
            int mid = left; //mid向右移动，看在right之前能否找到右子树的节点
            while (postorder[mid] < postorder[right]) {
                mid++;
            }
            //此时p[mid]大于根节点，开始遍历右子树节点
            int temp = mid;
            while (temp < right) {
                if (postorder[temp++] < postorder[right]) return false;
            }
            //本层合法，进入下一层判断
            return recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}