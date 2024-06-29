// 
// @Question: [2710]移除字符串中的尾随零 
// @Author: cwp0
// @CreatedTime: 2024-06-29 15:41:30
// @Description: 
//给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。 
//
// 
//
// 示例 1： 
//
// 输入：num = "51230100"
//输出："512301"
//解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
// 
//
// 示例 2： 
//
// 输入：num = "123"
//输出："123"
//解释：整数 "123" 不含尾随零，返回整数 "123" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 1000 
// num 仅由数字 0 到 9 组成 
// num 不含前导零 
// 
//
// Related Topics 字符串 👍 23 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeTrailingZeros(String num) {
        int n = num.length();
        String res = "";
        for (int i = n-1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                continue;
            } else {
                res = num.substring(0, i+1);
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
