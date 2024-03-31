package interview.Tencent;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.Tencent
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 20:42
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            graph.get(u).add(v);
        }



    }

    private static void dfs(List<List<Integer>> graph, int node, int sum, int[] count) {

    }

}