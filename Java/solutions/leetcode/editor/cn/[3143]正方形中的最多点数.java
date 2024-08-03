// 
// @Question: [3143]正方形中的最多点数 
// @Author: cwp0
// @CreatedTime: 2024-08-03 13:43:59
// @Description: 
//给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。 
//
// 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。 
//
// 请你返回 合法 正方形中可以包含的 最多 点数。 
//
// 注意： 
//
// 
// 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。 
// 正方形的边长可以为零。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca" 
// 
//
// 输出：2 
//
// 解释： 
//
// 边长为 4 的正方形包含两个点 points[0] 和 points[1] 。 
//
// 示例 2： 
//
// 
//
// 
// 输入：points = [[1,1],[-2,-2],[-2,2]], s = "abb" 
// 
//
// 输出：1 
//
// 解释： 
//
// 边长为 2 的正方形包含 1 个点 points[0] 。 
//
// 示例 3： 
//
// 
// 输入：points = [[1,1],[-1,-1],[2,-2]], s = "ccd" 
// 
//
// 输出：0 
//
// 解释： 
//
// 任何正方形都无法只包含 points[0] 和 points[1] 中的一个点，所以合法正方形中都不包含任何点。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, points.length <= 10⁵ 
// points[i].length == 2 
// -10⁹ <= points[i][0], points[i][1] <= 10⁹ 
// s.length == points.length 
// points 中的点坐标互不相同。 
// s 只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 二分查找 排序 👍 25 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] min1 = new int[26];
        Arrays.fill(min1, 1000000001);
        int min2 = 1000000001, n = s.length();
        for (int i = 0; i < n; ++i) {
            int x = points[i][0], y = points[i][1], j = s.charAt(i) - 'a';
            int d = Math.max(Math.abs(x), Math.abs(y));
            if (d < min1[j]) {
                min2 = Math.min(min2, min1[j]);
                min1[j] = d;
            } else if (d < min2) {
                min2 = d;
            }
        }
        int res = 0;
        for (int d : min1) {
            if (d < min2) {
                ++res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
