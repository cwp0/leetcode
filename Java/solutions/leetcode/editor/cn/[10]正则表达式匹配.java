// 
// @Question: [10]正则表达式匹配 
// @Author: cwp0
// @CreatedTime: 2024-04-11 16:19:50
// @Description: 
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3882 👎 0

import java.util.Arrays;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 备忘录
    private int[][] memo;
    public boolean isMatch(String s, String p) {
        // 初始化备忘录
        memo = new int[s.length()][p.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 动态规划
        // 结果为从s和p都从0开始
        return dp(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    // 定义dp(s, i, p, j)为s[i..]是否可以匹配p[j..]
    private boolean dp(char[] s, int i, char[] p, int j) {
        // base case
        // 如果p串走到了头，则判断s串是否走到头即可
        if (p.length == j) {
            return s.length == i;
        }
        // 如果s串走到了头，则不能以p串是否到头为判断依据
        // s = "a"    p = "ab*c*"
        // 此时p[j..]必须为x*y*z*这样的格式，因为*可以让前面的字符重复0次，也就是 p = "ab*c*" 后面的 "b*c*"相当于是 ""
        if (s.length == i) {
            // 如果p串剩余长度为奇数，不可能凑成b*c*这样的串
            if ((p.length - j) % 2 == 1) {
                return false;
            }
            // 检查是否为x*y*z*格式
            for (int m = j; m + 1 < p.length; m += 2) {
                if (p[m+1] != '*') {
                    return false;
                }
            }
            return true;
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean res = false;
        // 状态转移函数
        if (s[i] == p[j] || p[j] == '.') {
            if (j+1 < p.length && p[j+1] == '*') {
                // 通配符*匹配0次 || 匹配多次
                res = dp(s, i, p, j+2) || dp(s, i+1, p, j);
            } else {
                // 常规匹配，s、p都向前一步
                res = dp(s, i+1, p, j+1);
            }
        } else {
            if (j+1 < p.length && p[j+1] == '*') {
                // 通配符*匹配0次
                res = dp(s, i, p, j+2);
            } else {
                // 无法匹配
                res = false;
            }
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
