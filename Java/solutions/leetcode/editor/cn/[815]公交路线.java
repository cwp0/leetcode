// 
// @Question: [815]公交路线 
// @Author: cwp0
// @CreatedTime: 2024-09-17 14:29:08
// @Description: 
//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 10⁵ 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 10⁵ 
// 0 <= routes[i][j] < 10⁶ 
// 0 <= source, target < 10⁶ 
// 
//
// Related Topics 广度优先搜索 数组 哈希表 👍 407 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 记录经过车站 x 的公交车编号
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int x : routes[i]) {
                stopToBuses.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        // 小优化：如果没有公交车经过起点或终点，直接返回
        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
            // 注意原地 TP 的情况
            return source != target ? -1 : 0;
        }

        // BFS
        Map<Integer, Integer> dis = new HashMap<>();
        dis.put(source, 0);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        while (!q.isEmpty()) {
            int x = q.poll(); // 当前在车站 x
            int disX = dis.get(x);
            for (int i : stopToBuses.get(x)) { // 遍历所有经过车站 x 的公交车 i
                if (routes[i] != null) {
                    for (int y : routes[i]) { // 遍历公交车 i 的路线
                        if (!dis.containsKey(y)) { // 没有访问过车站 y
                            dis.put(y, disX + 1); // 从 x 站上车然后在 y 站下车
                            q.add(y);
                        }
                    }
                    routes[i] = null; // 标记 routes[i] 遍历过
                }
            }
        }

        return dis.getOrDefault(target, -1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
