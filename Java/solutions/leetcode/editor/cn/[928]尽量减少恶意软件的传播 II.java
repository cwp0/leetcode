// 
// @Question: [928]尽量减少恶意软件的传播 II 
// @Author: cwp0
// @CreatedTime: 2024-04-17 13:49:06
// @Description: 
//给定一个由 n 个节点组成的网络，用 n x n 个邻接矩阵 graph 表示。在节点网络中，只有当 graph[i][j] = 1 时，节点 i 能够直接
//连接到另一个节点 j。 
//
// 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传
//播将继续，直到没有更多的节点可以被这种方式感染。 
//
// 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。 
//
// 我们可以从 initial 中删除一个节点，并完全移除该节点以及从该节点到任何其他节点的任何连接。 
//
// 请返回移除后能够使 M(initial) 最小化的节点。如果有多个节点满足条件，返回索引 最小的节点 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
//输出：0
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// n == graph.length 
// n == graph[i].length 
// 2 <= n <= 300 
// graph[i][j] 是 0 或 1. 
// graph[i][j] == graph[j][i] 
// graph[i][i] == 1 
// 1 <= initial.length < n 
// 0 <= initial[i] <= n - 1 
// initial 中每个整数都不同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 哈希表 👍 85 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 链接：https://leetcode.cn/problems/minimize-malware-spread-ii/solutions/2743395/ni-xiang-si-wei-pythonjavaccgojsrust-by-jinc3/
    // 不会写。。。
    private int nodeId, size;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int mn = Integer.MAX_VALUE;
        for (int x : initial) {
            isInitial[x] = true;
            mn = Math.min(mn, x);
        }

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || isInitial[i]) {
                continue;
            }
            nodeId = -1;
            size = 0;
            dfs(i, graph, vis, isInitial);
            if (nodeId >= 0) { // 只找到一个在 initial 中的节点
                // 删除节点 nodeId 可以让 size 个点不被感染
                cnt[nodeId] += size;
            }
        }

        int maxCnt = 0;
        int minNodeId = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                minNodeId = i;
            }
        }
        return minNodeId < 0 ? mn : minNodeId;
    }

    private void dfs(int x, int[][] graph, boolean[] vis, boolean[] isInitial) {
        vis[x] = true;
        size++;
        for (int y = 0; y < graph.length; y++) {
            if (graph[x][y] == 0) {
                continue;
            }
            if (isInitial[y]) {
                // 按照 924 题的状态机更新 nodeId
                // 注意避免重复统计，例如上图中的 0 有两条不同路径可以遇到 1
                if (nodeId != -2 && nodeId != y) {
                    nodeId = nodeId == -1 ? y : -2;
                }
            } else if (!vis[y]) {
                dfs(y, graph, vis, isInitial);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
