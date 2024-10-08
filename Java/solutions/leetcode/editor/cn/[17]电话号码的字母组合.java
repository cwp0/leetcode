// 
// @Question: [17]电话号码的字母组合 
// @Author: cwp0
// @CreatedTime: 2024-10-08 14:18:30
// @Description: 
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2915 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution {
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从digits[0]开始回溯
        backtrack(digits, 0);
        return res;
    }

    void backtrack(String digits, int start) {
        // 到达回溯树的底部
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // 回溯算法框架
        int digit = digits.charAt(start) - '0';
        for (char c : mapping[digit].toCharArray()) {
            // 做选择
            sb.append(c);
            // 递归下一次回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
