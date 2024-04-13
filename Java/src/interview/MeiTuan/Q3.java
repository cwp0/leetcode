package interview.MeiTuan;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/13 19:57
 * @Version: 1.0
 */
public class Q3 {
    private static List<List<Integer>> adjList;
    private static String color;
    private static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        color = in.next();
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        count = 0;

        dfs(1, -1);

        System.out.println(count);
    }

    private static boolean[] dfs(int node, int parent) {
        boolean[] subtreeColors = new boolean[2]; // [0] 表示是否包含红色节点 [1]表示是否包含黑色节点

        if (color.charAt(node - 1) == 'R') {
            subtreeColors[0] = true;
        } else if (color.charAt(node - 1) == 'B') {
            subtreeColors[1] = true;
        }

        // 遍历临近节点
        for (int neighbor : adjList.get(node)) {
            // 跳过父节点
            if (neighbor == parent) continue;

            // dfs
            boolean[] childColors = dfs(neighbor, node);

            subtreeColors[0] |= childColors[0];
            subtreeColors[1] |= childColors[1];
        }
        // 检查当前子树中是否同时包含红色和黑色节点
        if (subtreeColors[0] && subtreeColors[1]) {
            count++;
        }
        return subtreeColors;
    }

}