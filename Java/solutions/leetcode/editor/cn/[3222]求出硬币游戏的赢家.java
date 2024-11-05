// 
// @Question: [3222]求出硬币游戏的赢家 
// @Author: cwp0
// @CreatedTime: 2024-11-05 14:52:47
// @Description: 
//给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。 
//
// Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名
//玩家无法执行此操作，那么这名玩家 输掉 游戏。 
//
// 两名玩家都采取 最优 策略，请你返回游戏的赢家。 
//
// 
//
// 示例 1： 
//
// 
// 输入：x = 2, y = 7 
// 
//
// 输出："Alice" 
//
// 解释： 
//
// 游戏一次操作后结束： 
//
// 
// Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 
// 
//
// 示例 2： 
//
// 
// 输入：x = 4, y = 11 
// 
//
// 输出："Bob" 
//
// 解释： 
//
// 游戏 2 次操作后结束： 
//
// 
// Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 
// Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x, y <= 100 
// 
//
// Related Topics 数学 博弈 模拟 👍 18 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String losingPlayer(int x, int y) {
        int index = 0;
        while (true) {
            if (x >= 1 && y >= 4) {
                x -= 1;
                y -= 4;
                index++;
            } else {
                break;
            }
        }
        return index % 2 == 0 ? "Bob" : "Alice";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
