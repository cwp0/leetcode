// 
// @Question: [140]单词拆分 II 
// @Author: cwp0
// @CreatedTime: 2024-04-01 13:47:01
// @Description: 
//给定一个字符串 s 和一个字符串字典
// wordDict ，在字符串
// s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。 
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 回溯 👍 742 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用哈希集合更快的查询wordDict
    HashSet<String> wordDict;
    // 备忘录
    List<String>[] memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        memo = new List[s.length()];
        return dp(s, 0);
    }

    // 定义dp[s, i]为s[i..]之后用wordDict拼凑的所有组合
    private List<String> dp (String s, int i) {
        List<String> res = new ArrayList<>();

        // base case
        if (i == s.length()) {
            res.add(""); // 为啥？？？好像没太懂。
            return res;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        // 状态转移函数
        for (int len = 1; i + len <= s.length(); len++) {
            String prefix = s.substring(i, i + len);
            // 前缀存在于wordDict中
            if (wordDict.contains(prefix)) {
                // 构成子问题s[i+len..]的所有组合再加上prefix就是s[i..]的所有组合
                List<String> subProblem = dp(s, i + len);

                for (String str : subProblem) {
                    if (str.isEmpty()) {
                        res.add(prefix);
                    } else {
                        res.add(prefix + " " + str);
                    }
                }

            }
        }
        memo[i] = res;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
