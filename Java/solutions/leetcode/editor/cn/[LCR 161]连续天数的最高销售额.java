// 
// @Question: [LCR 161]连续天数的最高销售额 
// @Author: cwp0
// @CreatedTime: 2024-04-03 13:14:55
// @Description: 
//某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。 
//
// 要求实现时间复杂度为 O(n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入：sales = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：[4,-1,2,1] 此连续四天的销售总额最高，为 6。 
//
// 示例 2: 
//
// 
//输入：sales = [5,4,-1,7,8]
//输出：23
//解释：[5,4,-1,7,8] 此连续五天的销售总额最高，为 23。  
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// Related Topics 数组 分治 动态规划 👍 746 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSales(int[] sales) {

        // 定义dp[i]为以sales[i]结尾的销售额最大值。
        int[] dp = new int[sales.length];

        // base case
        dp[0] = sales[0];

        // 状态转移函数
        for (int i = 1; i < sales.length; i++) {
            // dp[i]有两种选择：
            // 1. sales[i]与前面dp[i-1]形成销售额最大值
            // 2. sales[i]自己就比前面大，自己成为一个最大值
            dp[i] = Math.max(sales[i] + dp[i-1], sales[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
