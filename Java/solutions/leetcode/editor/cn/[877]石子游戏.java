// 
// @Question: [877]石子游戏 
// @Author: cwp0
// @CreatedTime: 2024-04-15 13:10:25
// @Description: 
//Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。 
//
// 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。 
//
// Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此
//时手中 石子最多 的玩家 获胜 。 
//
// 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [5,3,4,5]
//输出：true
//解释：
//Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
//假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
//如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
//这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：piles = [3,7,2,3]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 2 <= piles.length <= 500 
// piles.length 是 偶数 
// 1 <= piles[i] <= 500 
// sum(piles[i]) 是 奇数 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 537 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGame(int[] piles) {
        return stoneGames(piles) > 0;
    }

    private int stoneGames(int[] piles) {
        int n = piles.length;
        // 定义dp[i][j][first,second]，其中dp[i][j].first为从piles[i]到piles[j]先手获得的最大石子数
        // dp[i][j].second为从piles[i]到piles[j]后手获得的最大石子数
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        // base case
        // i == j，先手拿走石子，后手没有石子可拿
        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
        }

        // i 从下往上遍历，j从左往右遍历
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j <= n-1; j++) {
                // 先手分两种情况:
                // 先选左边的石子，选完后变为后手，最大化后手收益
                int left = piles[i] + dp[i+1][j].second;
                // 先选右边的石子，同上
                int right = piles[j] + dp[i][j-1].second;
                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i+1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j-1].first;
                }
            }
        }

        return dp[0][n-1].first - dp[0][n-1].second;
    }

}

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
