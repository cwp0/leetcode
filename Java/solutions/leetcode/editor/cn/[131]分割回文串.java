// 
// @Question: [131]分割回文串 
// @Author: cwp0
// @CreatedTime: 2024-10-15 15:28:25
// @Description: 
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1869 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    // 回溯算法框架
    private void backtrack(String s, int start) {
        if (start == s.length()) {
            // 走到了叶子节点，这是一种情况。
            res.add(new ArrayList<>(track));
        }
        // 多种选择
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                // s[start..i] 不是回文串
                continue;
            }
            // s[start..i]是回文串，可以进行分隔
            // 做选择，把s[start..i]放入track
            track.addLast(s.substring(start, i+1));
            // 进入回溯树的下一层，继续切分s[i+1..]
            backtrack(s, i+1);
            // 撤销选择
            track.removeLast();

        }
    }

    // 判断是否是回文串
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
