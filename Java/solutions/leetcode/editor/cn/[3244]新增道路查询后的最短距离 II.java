// 
// @Question: [3244]新增道路查询后的最短距离 II 
// @Author: cwp0
// @CreatedTime: 2024-11-20 19:12:14
// @Description: 
//给你一个整数 n 和一个二维整数数组 queries。 
//
// 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。 
//
// queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最
//短路径的长度。 
//
// 所有查询中不会存在两个查询都满足 queries[i][0] < queries[j][0] < queries[i][1] < queries[j][1
//]。 
//
// 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，
//从城市 0 到城市 n - 1 的最短路径的长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]] 
// 
//
// 输出： [3, 2, 1] 
//
// 解释： 
//
// 
//
// 新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。 
//
// 
//
// 新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。 
//
// 
//
// 新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。 
//
// 示例 2： 
//
// 
// 输入： n = 4, queries = [[0, 3], [0, 2]] 
// 
//
// 输出： [1, 1] 
//
// 解释： 
//
// 
//
// 新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。 
//
// 
//
// 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。 
//
// 
//
// 提示: 
//
// 
// 3 <= n <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= queries[i][0] < queries[i][1] < n 
// 1 < queries[i][1] - queries[i][0] 
// 查询中不存在重复的道路。 
// 不存在两个查询都满足 i != j 且 queries[i][0] < queries[j][0] < queries[i][1] < queries[
//j][1]。 
// 
//
// Related Topics 贪心 图 数组 有序集合 👍 42 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] roads = new int[n];
        for (int i = 0; i < n; i++) {
            roads[i] = i + 1;
        }
        int[] res = new int[queries.length];
        int dist = n - 1;
        for (int i = 0; i < queries.length; i++) {
            int k = roads[queries[i][0]];
            roads[queries[i][0]] = queries[i][1];
            while (k != -1 && k < queries[i][1]) {
                int t = roads[k];
                roads[k] = -1;
                k = t;
                dist--;
            }
            res[i] = dist;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

