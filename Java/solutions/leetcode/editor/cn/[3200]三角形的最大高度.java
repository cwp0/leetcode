// 
// @Question: [3200]三角形的最大高度 
// @Author: cwp0
// @CreatedTime: 2024-10-15 13:15:24
// @Description: 
//给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 
//3 行有 3 个球，依此类推。 
//
// 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。 
//
// 返回可以实现的三角形的 最大 高度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： red = 2, blue = 4 
// 
//
// 输出： 3 
//
// 解释： 
//
// 
//
// 上图显示了唯一可能的排列方式。 
//
// 示例 2： 
//
// 
// 输入： red = 2, blue = 1 
// 
//
// 输出： 2 
//
// 解释： 
//
// 上图显示了唯一可能的排列方式。 
//
// 示例 3： 
//
// 
// 输入： red = 1, blue = 1 
// 
//
// 输出： 1 
//
// 示例 4： 
//
// 
// 输入： red = 10, blue = 1 
// 
//
// 输出： 2 
//
// 解释： 
//
// 上图显示了唯一可能的排列方式。 
//
// 
//
// 提示： 
//
// 
// 1 <= red, blue <= 100 
// 
//
// Related Topics 数组 枚举 👍 18 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(maxHeight(red, blue), maxHeight(blue, red));
    }

    public int maxHeight(int x, int y) {
        int i = 1;
        do {
            if (i % 2 == 1) {
                x -= i;
                if (x < 0) {
                    return i - 1;
                }
            } else {
                y -= i;
                if (y < 0) {
                    return i - 1;
                }
            }
            i++;
        } while (true);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
