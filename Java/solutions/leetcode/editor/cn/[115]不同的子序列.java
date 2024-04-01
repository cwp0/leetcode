// 
// @Question: [115]不同的子序列 
// @Author: cwp0
// @CreatedTime: 2024-03-31 19:32:11
// @Description: 
//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10⁹ + 7 取模。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1222 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution {
    // 备忘录
    int[][] memo;
    public int numDistinct(String s, String t) {
        // 备忘录
        memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, t, 0);
    }

    // 定义dp数组为 s[i..] 的子序列中 t[j..] 出现的次数 dp(s, i, t, j)
    private int dp(String s, int i, String t, int j) {

        // base case
        // 如果j == t的长度，则匹配完毕。
        if (t.length() == j) return 1;
        // 如果 s[i..] 的长度小于 t[j..]的长度，则肯定匹配不了
        if (s.length() - i < t.length() - j) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int res = 0;
        // 状态转移函数
        if (s.charAt(i) == t.charAt(j)) {
            // s[i] == t[j] 分两种：(从 s 的视角看)
            // 1.可以匹配就让其匹配，开始匹配 s[i+1] 和 t[j+1]
            // 2.可以匹配但是不匹配，让 s[i+1] 和 t[j] 匹配
            res += dp(s, i+1, t, j+1) + dp(s, i+1, t, j);
        } else {
            // s[i] != t[j] 则让 s[i+1] 和 t[j] 匹配
            res += dp(s, i+1, t, j);
        }
        memo[i][j] = res;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
