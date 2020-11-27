package leetcode.editor.cn;


public class A_134GasStation {
    public static void main(String[] args) {
        Solution solution = new A_134GasStation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            //retainedGas[i]=gas[i]-cost[i]：表示从gas[i]到gas[i+1]的油量净增长（或者净消耗）
            int[] retainedGas = new int[gas.length];
            for (int i = 0; i < retainedGas.length; i++) {
                retainedGas[i] = gas[i] - cost[i];
            }

            //设汽车从gas[0]出发（无论从哪点出发，在某个加油站gas[j]的油量剩余都是最低的，只要找到j，从gas[j+1]出发即可
            int restGas = 0;
            int minRestGas = Integer.MAX_VALUE;
            int minID = 0;

            for (int i = 0; i < gas.length; i++) {
                restGas += retainedGas[i];
                //实时维护一个最小的剩余油量的加油站ID
                if (restGas < minRestGas) {
                    minRestGas = restGas;
                    minID = i;
                }
            }
            //若油量剩余最小量<0，说明不可能完成环圈
            return restGas < 0 ? -1 : (minID + 1) % gas.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}