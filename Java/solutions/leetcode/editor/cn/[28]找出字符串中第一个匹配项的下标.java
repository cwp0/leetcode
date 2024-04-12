// 
// @Question: [28]找出字符串中第一个匹配项的下标 
// @Author: cwp0
// @CreatedTime: 2024-04-11 20:43:58
// @Description: 
//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2200 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int res = -1;
        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        // 记录needle中每个字符出现的次数
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : needle.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 记录window中合法字符的个数
        int valid = 0;
        while (right < haystack.length()) {
            char c = haystack.charAt(right);
            // 增大窗口
            right++;
            // 增大窗口后对数据进行处理
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 是否可以缩小窗口
            // 窗口的长度等于needle字符串的长度
            while (right - left == needle.length()) {
                // window中合法字符数量等于need的尺寸, 且子串相等
                if (valid == need.size() && haystack.substring(left, right).equals(needle)) {
                    res = left;
                    break;
                }
                char d = haystack.charAt(left);
                // 缩小窗口
                left++;
                // 缩小窗口后对数据进行处理
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }


        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
