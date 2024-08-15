// 
// @Question: [3148]矩阵中的最大得分 
// @Author: cwp0
// @CreatedTime: 2024-08-15 13:59:38
// @Description: 
//给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 
//c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。 
//
// 你可以从 任一 单元格开始，并且必须至少移动一次。 
//
// 返回你能得到的 最大 总得分。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]] 
// 
//
// 输出：9 
//
// 解释：从单元格 (0, 1) 开始，并执行以下移动： - 从单元格 (0, 1) 移动到 (2, 1)，得分为 7 - 5 = 2 。 - 从单元格 (2
//, 1) 移动到 (2, 2)，得分为 14 - 7 = 7 。 总得分为 2 + 7 = 9 。 
//
// 示例 2： 
//
// 
//
// 
// 输入：grid = [[4,3,2],[3,2,1]] 
// 
//
// 输出：-1 
//
// 解释：从单元格 (0, 0) 开始，执行一次移动：从 (0, 0) 到 (0, 1) 。得分为 3 - 4 = -1 。 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 38 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] prerow = new int[m][n];
        int[][] precol = new int[m][n];
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], grid.get(i).get(j) + precol[i - 1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], grid.get(i).get(j) + prerow[i][j - 1]);
                }
                ans = Math.max(ans, f[i][j]);
                prerow[i][j] = precol[i][j] = Math.max(f[i][j], 0) - grid.get(i).get(j);
                if (i > 0) {
                    precol[i][j] = Math.max(precol[i][j], precol[i - 1][j]);
                }
                if (j > 0) {
                    prerow[i][j] = Math.max(prerow[i][j], prerow[i][j - 1]);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
