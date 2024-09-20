// 
// @Question: [2376]统计特殊整数 
// @Author: cwp0
// @CreatedTime: 2024-09-20 12:54:15
// @Description: 
//如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。 
//
// 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：19
//解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
//解释：1 到 5 所有整数都是特殊整数。
// 
//
// 示例 3： 
//
// 
//输入：n = 135
//输出：110
//解释：从 1 到 135 总共有 110 个整数是特殊整数。
//不特殊的部分数字为：22 ，114 和 131 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 👍 109 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int countSpecialNumbers(int n) {
        String nStr = String.valueOf(n);
        int res = 0;
        int prod = 9;
        // 数字位数小于n的特殊数字数目
        for (int i = 0; i < nStr.length() - 1; i++) {
            res += prod;
            prod *= 9 - i;
        }
        // 数字位数等于n的特殊数字数目
        res += dp(0, false, nStr);
        return res;
    }

    public int dp(int mask, boolean prefixSmaller, String nStr) {
        if (Integer.bitCount(mask) == nStr.length()) {
            return 1;
        }
        int key = mask * 2 + (prefixSmaller ? 1 : 0);
        if (!memo.containsKey(key)) {
            int res = 0;
            int lowerBound = mask == 0 ? 1 : 0;
            int upperBound = prefixSmaller ? 9 : nStr.charAt(Integer.bitCount(mask)) - '0';
            for (int i = lowerBound; i <= upperBound; i++) {
                if (((mask >> i) & 1) == 0) {
                    res += dp(mask | (1 << i), prefixSmaller || i < upperBound, nStr);
                }
            }
            memo.put(key, res);
        }
        return memo.get(key);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
