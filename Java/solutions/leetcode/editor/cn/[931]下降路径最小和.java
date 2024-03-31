// 
// @Question: [931]下降路径最小和 
// @Author: cwp0
// @CreatedTime: 2024-03-30 16:36:12
// @Description: 
//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 340 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // 定义dp[i][j] 为 从matrix[0][] 下降到 matrix[i][j]的最小路径和。
        int[][] dp = new int[n][n];

        // base case
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // 注意从第二行开始
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 矩阵左边界
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == n-1) {
                    // 矩阵右边界
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    // 状态转移方程
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
                }
            }
        }

        // 最小路径和可能在dp数组中最后一行任意一列，遍历一下。
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n-1][j]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
