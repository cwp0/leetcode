package interview.XiaoHongShu;

/**
 * @Program: Java
 * @Package: interview.XiaoHongShu
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/14 16:00
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static int n, q;
    public static List<List<int[]>> tree;
    public static long[] xorToNode;
    public static Map<Long, Integer> xorCount;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();

        tree = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long w = scanner.nextLong();
            tree.get(u).add(new int[]{v, (int) w});
            tree.get(v).add(new int[]{u, (int) w});
        }

        xorToNode = new long[n+1];
        xorCount = new HashMap<>();

        dfs(1, -1, 0);
        for (int i = 0; i < q; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long k = scanner.nextLong();
            long targetXOR = xorToNode[u] ^ k;
            System.out.println(xorCount.getOrDefault(targetXOR, 0));
        }
        scanner.close();
    }

    private static void dfs(int node, int praent, long xorValue) {
        xorToNode[node] = xorValue;
        xorCount.put(xorValue, xorCount.getOrDefault(xorValue, 0) + 1);
        for (int[] neighbor : tree.get(node)) {
            int nextNode = neighbor[0];
            long edgeWeight = neighbor[1];
            if (nextNode != praent) {
                dfs(nextNode, node, xorValue ^ edgeWeight);
            }
        }

    }
}