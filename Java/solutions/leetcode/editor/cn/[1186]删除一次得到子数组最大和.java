// 
// @Question: [1186]删除一次得到子数组最大和 
// @Author: cwp0
// @CreatedTime: 2024-07-21 19:54:48
// @Description: 
//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以
//决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 
//输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 
//输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 345 👎 0

import java.util.Arrays;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] arr;
    private int[][] memo;

    public int maximumSum(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        memo = new int[n][2];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
        return ans;
    }

    private int dfs(int i, int j) {
        if (i < 0) return Integer.MIN_VALUE / 2; // 除 2 防止负数相加溢出
        if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j]; // 之前计算过
        if (j == 0) return memo[i][j] = Math.max(dfs(i - 1, 0), 0) + arr[i];
        return memo[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
