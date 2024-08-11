// 
// @Question: [1035]不相交的线 
// @Author: cwp0
// @CreatedTime: 2024-08-11 14:14:09
// @Description: 
//在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。 
//
// 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足： 
//
// 
// nums1[i] == nums2[j] 
// 且绘制的直线不与任何其他连线（非水平线）相交。 
// 
//
// 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。 
//
// 以这种方法绘制线条，并返回可以绘制的最大连线数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums1 = [1,4,2], nums2 = [1,2,4]
//输出：2
//解释：可以画出两条不交叉的线，如上图所示。 
//但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相
//交。
// 
//
// 
// 示例 2： 
// 
//
// 
//输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
//输出：3
// 
//
// 
// 示例 3： 
// 
//
// 
//输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
//输出：2 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 500 
// 1 <= nums1[i], nums2[j] <= 2000 
// 
//
// 
//
// Related Topics 数组 动态规划 👍 573 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 转化为求两数组的最长公共子序列
        // dp[i][j]表示nums1[0, i] nums2[0, j]的最长公共子序列
        int[][] dp = new int[m+1][n+1];

        // base case
        // 两空数组的最长公共子序列为0
        // dp[0][0] = 0;
        // 任何数组和空数组的最长公共子序列为0
        // dp[i][0] = 0;
        // dp[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
