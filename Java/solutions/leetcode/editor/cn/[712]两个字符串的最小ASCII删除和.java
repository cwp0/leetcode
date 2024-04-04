// 
// @Question: [712]两个字符串的最小ASCII删除和 
// @Author: cwp0
// @CreatedTime: 2024-04-03 20:39:19
// @Description: 
//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 380 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s1, 0, s2, 0);
    }

    // 定义dp[s1, i, s2, j]为s1[i..]与s2[j..]相等所需删除字符的最小ASCII码之和。
    private int dp(String s1, int i, String s2, int j) {
        // 最小和
        int res = 0;
        // base case
        // 如果s1走到头，那么s2中的所有剩余字符均需要删除
        if (i == s1.length()) {
            for(; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        // 如果s2走到头，那么s1中的所有剩余字符均需要删除
        if (j == s2.length()) {
            for(; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移函数
        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果相等，则不用删除
            memo[i][j] = dp(s1, i+1, s2, j+1);
        } else {
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i+1, s2, j), s2.charAt(j) + dp(s1, i, s2, j+1));
        }

        return memo[i][j];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
