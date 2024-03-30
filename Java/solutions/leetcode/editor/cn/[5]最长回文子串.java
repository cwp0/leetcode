// 
// @Question: [5]最长回文子串 
// @Author: cwp0
// @CreatedTime: 2024-03-11 11:40:38
// @Description: 
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7103 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r <= s.length() -1 && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        // 注意这里的l+1，原因是前面的while循环在s.charAt(l) == s.charAt(r)执行之前会l--和r++，在不满足前面条件时，已经进行了l--和r++，所以需要加回来。
        return s.substring(l+1, r);
    }
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i ++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
