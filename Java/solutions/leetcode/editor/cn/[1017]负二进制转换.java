// 
// @Question: [1017]负二进制转换 
// @Author: cwp0
// @CreatedTime: 2024-04-28 16:15:49
// @Description: 
//给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。 
//
// 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出："110"
//解释：(-2)² + (-2)¹ = 2
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出："111"
//解释：(-2)² + (-2)¹ + (-2)⁰ = 3
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出："100"
//解释：(-2)² = 4
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 数学 👍 209 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int[] bits = new int[32];
        for (int i = 0; i < 32 && n != 0; i++) {
            if ((n & 1) != 0) {
                bits[i]++;
                if ((i & 1) != 0) {
                    bits[i + 1]++;
                }
            }
            n >>= 1;
        }
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int val = carry + bits[i];
            bits[i] = val & 1;
            carry = (val - bits[i]) / (-2);
        }
        int pos = 31;
        StringBuilder res = new StringBuilder();
        while (pos >= 0 && bits[pos] == 0) {
            pos--;
        }
        while (pos >= 0) {
            res.append(bits[pos]);
            pos--;
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
