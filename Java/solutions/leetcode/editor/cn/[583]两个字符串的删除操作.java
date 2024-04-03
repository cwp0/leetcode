// 
// @Question: [583]两个字符串的删除操作 
// @Author: cwp0
// @CreatedTime: 2024-04-03 19:58:58
// @Description: 
//给定两个单词 word1 和
// word2 ，返回使得
// word1 和 
// word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
//
// Related Topics 字符串 动态规划 👍 669 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int lcs = dp(word1, 0, word2, 0);
        return m - lcs + n - lcs;
    }

    // 定义dp(s1, i, s2, j)为s1[i..]和s2[j..]的最长公共子序列
    private int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        // 状态转移函数
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i+1, s2, j+1);
        } else {
            memo[i][j] = Math.max(dp(s1, i+1, s2, j), dp(s1, i, s2, j+1));
        }
        return memo[i][j];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
