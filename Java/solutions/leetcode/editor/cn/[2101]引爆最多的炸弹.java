// 
// @Question: [2101]引爆最多的炸弹 
// @Author: cwp0
// @CreatedTime: 2024-07-22 12:22:24
// @Description: 
//给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。 
//
// 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 
//X 和 Y 坐标，ri 表示爆炸范围的 半径 。 
//
// 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。 
//
// 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：bombs = [[2,1,3],[6,1,4]]
//输出：2
//解释：
//上图展示了 2 个炸弹的位置和爆炸范围。
//如果我们引爆左边的炸弹，右边的炸弹不会被影响。
//但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
//所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：bombs = [[1,1,5],[10,10,5]]
//输出：1
//解释：
//引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
//输出：5
//解释：
//最佳引爆炸弹为炸弹 0 ，因为：
//- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
//- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
//- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
//所以总共有 5 个炸弹被引爆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bombs.length <= 100 
// bombs[i].length == 3 
// 1 <= xi, yi, ri <= 10⁵ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 几何 数组 数学 👍 81 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        // 建图，n个炸弹看成n个节点
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r = bombs[i][2];
                // 如果j距离i小鱼ri，则i的爆炸可以引爆j
                if (dx * dx + dy * dy <= r * r) {
                    graph[i].add(j); // 有向图
                }
            }
        }
        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            res = Math.max(res, dfs(graph, visited, i));
        }
        return res;
    }

    private int dfs(List<Integer>[] graph, boolean[] visited, int i) {
        visited[i] = true;
        int count = 1;
        for (int j : graph[i]) {
            if (!visited[j]) {
                count += dfs(graph, visited, j);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
