// 
// @Question: [72]编辑距离 
// @Author: cwp0
// @CreatedTime: 2024-04-01 23:58:42
// @Description: 
//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3349 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 备忘录
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(word1, m - 1, word2, n - 1);
    }

    // 定义dp[s1, i, s2, j] 为s1[0..i]变为s2[0..j]的最小编辑距离
    private int dp(String s1, int i, String s2, int j) {
        // base case
        // 如果是s1从末尾走到了头，则需要将s2剩下的长度一个个插入s1，所以返回s2剩余长度
        if (i == -1) return j + 1;
        // 如果是s2从末尾走到了头，则需要将s1剩下的长度一个个删除，所以返回s2剩余长度
        if (j == -1) return i + 1;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移函数
        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果s1在i处的字符和s2在j处的字符相等，则不做操作，编辑距离不变。
            // dp[s1, i, s2, j] == dp[s1, i-1, s2, j-1]
            memo[i][j] = dp(s1, i - 1 , s2, j - 1);
        } else {
            // 如果不想等，则找出三种情况：插入、删除、替换操作的最小编辑距离的那个
            // 插入：在s1[i]后插入s2[j], s2前进，变为s2[j-1]继续与s1[i]比较，编辑次数+1
            // 替换：s1[i]替换为s2[j]，s1和s2都前进，变为s1[i-1]和s2[j-1]，编辑次数+1
            // 删除：删除s1[i]处的字符，s1前进，变为s1[i-1]继续与s2[j]比较，编辑次数+1
            memo[i][j] = min(
                dp(s1, i, s2, j - 1) + 1,
                dp(s1, i - 1, s2, j - 1) + 1,
                dp(s1, i - 1, s2, j) + 1
            );
        }
        return memo[i][j];

    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
