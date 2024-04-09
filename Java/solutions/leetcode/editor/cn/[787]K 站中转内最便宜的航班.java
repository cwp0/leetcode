// 
// @Question: [787]K 站中转内最便宜的航班 
// @Author: cwp0
// @CreatedTime: 2024-04-09 14:37:30
// @Description: 
//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 639 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用HashMap记录每个点的入度
    private HashMap<Integer, List<int[]>> indegree;
    private int src;
    private int dst;
    // 备忘录
    private int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 题中给出的是节点数，将其转化为边数
        k++;
        this.src = src;
        this.dst = dst;

        memo = new int[n][k+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        indegree = new HashMap<>();
        for (int[] row : flights) {
            int from = row[0];
            int to = row[1];
            int price = row[2];

            indegree.putIfAbsent(to, new ArrayList<>());
            indegree.get(to).add(new int[] {from, price});
        }

        return dp(dst, k);
    }
    // 定义dp(dst, k)为从起点src在k步之内可以到d的最小成本
    private int dp(int d, int k) {
        // base case
        // 特殊情况：如果出发点等于终点，代价为0
        if (d == src) return 0;
        // 如果k == 0 且这个点不是起点，则表示已经走了k个点
        if (k == 0) return -1;

        if (memo[d][k] != -1) return memo[d][k];

        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(d)) {
            for (int[] fp : indegree.get(d)) {
                int from = fp[0];
                int price = fp[1];

                int subProblem = dp(from, k-1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }

            }
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[d][k] = res;
        return memo[d][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
