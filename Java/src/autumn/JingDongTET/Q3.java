package autumn.JingDongTET;

/**
 * @Program: Java
 * @Package: autumn.JingDongTET
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/30 19:09
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        queue.offer(1);
        dist.put(1, 0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currTime = dist.get(curr);

            if (curr == n) {
                System.out.println(currTime);
                return;
            }

            if (graph.containsKey(curr)) {
                for (int next : graph.get(curr)) {
                    if (!dist.containsKey(next)) {
                        dist.put(next, currTime);
                        queue.offer(next);
                    }
                }
            }

            if (curr - 1 >= 1 && !dist.containsKey(curr - 1)) {
                dist.put(curr - 1, currTime + 1);
                queue.offer(curr - 1);
            }
            if (curr + 1 <= n && !dist.containsKey(curr + 1)) {
                dist.put(curr + 1, currTime + 1);
                queue.offer(curr + 1);
            }
        }

    }
}