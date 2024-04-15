// 
// @Question: [486]预测赢家 
// @Author: cwp0
// @CreatedTime: 2024-04-15 13:10:20
// @Description: 
//给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。 
//
// 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0
//] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取
//时，游戏结束。 
//
// 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分
//数最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,2]
//输出：false
//解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
//如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）
//可选。 
//所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
//因此，玩家 1 永远不会成为赢家，返回 false 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,233,7]
//输出：true
//解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
//最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 10⁷ 
// 
//
// Related Topics 递归 数组 数学 动态规划 博弈 👍 695 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean predictTheWinner(int[] nums) {
        return stoneGame(nums) >= 0;
    }

    // 返回先手得分 - 后手得分
    private int stoneGame(int[] nums) {
        int n = nums.length;
        // 定义dp[i][j][first, second]为从在从nums[i]到nums[j]中先手得分最大值，和后手得分最大值
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        // base case
        // 当dp[i][j]中i == j时，只有一个元素，则先手选择这个数字，后手没得选，为0(后手已经被初始化过了)
        for (int i = 0; i < n; i++) {
            dp[i][i].first = nums[i];
        }

        // 状态转移函数
        // i要从下往上遍历，j要从左往右遍历
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j <= n-1; j++) {
                // 对于先手来说，分两种情况
                // 选择左边的数nums[i]，然后变为后手，最大化后手分数
                int left = nums[i] + dp[i+1][j].second;
                // 选择右边的数nums[j]，然后变为后手，最大化后手分数
                int right = nums[j] + dp[i][j-1].second;
                // 选两种情况最大的
                dp[i][j].first = Math.max(left, right);
                if (left > right) {
                    // 如果先手选择了左边的数，那么后手此时变为先手
                    dp[i][j].second = dp[i+1][j].first;
                } else {
                    // 如果先手选择了右边的数，那么后手此时变为先手
                    dp[i][j].second = dp[i][j-1].first;
                }

            }
        }
        return dp[0][n-1].first - dp[0][n-1].second;
    }

}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
