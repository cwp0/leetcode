// 
// @Question: [354]俄罗斯套娃信封问题 
// @Auther: cwp0
// @CreatedTime: 2024-03-25 19:18:00
// @Description: 
//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 1000 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // envelops = [[width, height],[width, height]...]
        // 对信封按照宽度进行升序排列，如果宽度相同，则按照高度进行降序排列
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if(a[0] == b[0])
                // 按高度进行降序排列
                return b[1] - a[1];
            else
                // 按宽度进行升序排列
                return a[0] - b[0];
        });

        // 在高度数组中寻找最长子序列LIS，就是结果
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);

    }

    private int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }


    // 动态规划不行啊，好像超时。。
//    private int lengthofLIS(int[] nums) {
//        int n = nums.length;
//        // 定义dp数组为以每个nums数组元素为末尾的最长递增子序列
//        int[] dp = new int[n];
//        // base case 最长递增子序列最小为本身，即1
//        Arrays.fill(dp, 1);
//
//        // 自底向上计算，并记录
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j])
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//            }
//        }
//
//        // 遍历寻找LIS
//        int res = 0;
//        for(int i = 0; i < n; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
