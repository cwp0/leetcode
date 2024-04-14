// 
// @Question: [LCR 137]模糊搜索验证 
// @Author: cwp0
// @CreatedTime: 2024-04-11 16:21:30
// @Description: 
//请设计一个程序来支持用户在文本编辑器中的模糊搜索功能。用户输入内容中可能使用到如下两种通配符： 
//
// 
// '.' 匹配任意单个字符。 
// '*' 匹配零个或多个前面的那一个元素。 
// 
//
// 
//
// 请返回用户输入内容 input 所有字符是否可以匹配原文字符串 article。 
//
// 
//
// 示例 1: 
//
// 
//输入: article = "aa", input = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入: article = "aa", input = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 
//输入: article = "ab", input = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= article.length <= 20 
// 1 <= input.length <= 20 
// article 只包含从 a-z 的小写字母。 
// input 只包含从 a-z 的小写字母，以及字符 . 和 * 。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
//
// 
//
// Related Topics 递归 字符串 动态规划 👍 572 👎 0

import java.util.Arrays;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] memo;
    public boolean articleMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s.toCharArray(), 0, p.toCharArray(), 0);

    }
    // 定义dp[i][j]为s[i..]是否可以匹配p[j..]
    private boolean dp(char[] s, int i, char[] p, int j) {
        // base case
        // 如果p走到了尽头，判断s是否也走到了尽头
        if (p.length == j) {
            return s.length == i;
        }
        // 如果s走到了尽头，不能以p是否走到尽头作为base case
        // s: a  p: ab*c*  此时p[j..]必须为x*y*z*的形式，以凑出空串
        if (s.length == i) {
            // 如果p[j..]为奇数，必定凑不出x*y*z*的形式
            if ((p.length - j) % 2 == 1) {
                return false;
            }
            for (int m = j; m + 1 < p.length; m+= 2) {
                if (p[m+1] != '*') {
                    return false;
                }
            }
            return true;
        }
        // 查找备忘录避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean res = false;
        // 状态转移函数
        if (s[i] == p[j] || p[j] == '.') {
            if (j+1 < p.length && p[j+1] == '*') {
                // 如果p[j+1]为*，则*可以匹配0次或多次
                res = dp(s, i, p, j+2) || dp(s, i+1, p, j);
            } else {
                // 正常匹配一次，s和p都向前一步
                res = dp(s, i+1, p, j+1);
            }
        } else {
            if (j+1 < p.length && p[j+1] == '*') {
                // 如果s[i]不等于p[j]，则*只能匹配0次
                res = dp(s, i, p, j+2);
            } else {
                // 无法匹配
                return false;
            }
        }
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
