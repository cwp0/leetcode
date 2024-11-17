// 
// @Question: [139]单词拆分 
// @Author: cwp0
// @CreatedTime: 2024-11-17 20:58:53
// @Description: 
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2619 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    HashSet<String> set;
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);

        memo = new int[s.length()];
        // -1未计算，0不能被拼出，1可以被拼出
        Arrays.fill(memo, -1);

        return dp(s, 0);
    }

    // 定义dp(s, i)为s[i..]是否可以被拼接出。
    private boolean dp(String s, int i) {
        if (i == s.length()) return true;

        if (memo[i] != -1) return memo[i] == 1;

        for (int len = 1; i + len <= s.length(); len++) {
            // 如果prefix包含在wordDict里面
            String prefix = s.substring(i, i + len);
            if (set.contains(prefix)) {
                // 如果s[i+len..]可以被拼出，则s[i..]也可以被拼出
                if (dp(s, i + len)) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[i] = 0;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

