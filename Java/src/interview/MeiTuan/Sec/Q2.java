package interview.MeiTuan.Sec;

/**
 * @Program: Java
 * @Package: interview.MeiTuan.Sec
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 10:01
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    static List<Integer>[] tree;
    static int[] childNum;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            tree = new ArrayList[n+1];
            childNum = new int[n+1];
            for (int i = 1; i<= n; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < n-1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                tree[u].add(v);
                tree[v].add(u);
            }

            dfs(1, -1);

            Map<Integer, Integer> childCountMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                childCountMap.put(childNum[i], childCountMap.getOrDefault(childNum[i], 0) + 1);
            }

            long similar = 0;
            for (int count : childCountMap.values()) {
                similar += (long)count * (count - 1) /2;
            }
            System.out.println(similar);
        }
        scanner.close();
    }

    private static void dfs(int u, int parent) {
        int children = 0;
        for (int v : tree[u]) {
            if (v != parent) {
                dfs(v, u);
                children++;
            }
        }
        childNum[u] = children;
    }
}