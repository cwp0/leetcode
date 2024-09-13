package interview.DiDi;

/**
 * @Program: Java
 * @Package: interview.DiDi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/13 19:40
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] ops = new int[n+1]; // 每首歌的操作

            boolean isPossible = true;

            int lastDown = 0; // 上一次调低操作的歌曲编号
            int lastUp = n+1; // 上一次调高操作的歌曲编号

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int op = scanner.nextInt();
                int x = scanner.nextInt();

                map.put(op, map.getOrDefault(op, 0) + 1);

                if (op == 1) {
                    if (x <= lastDown) {
                        isPossible = false;
                        break;
                    }
                    lastDown = x;
                } else if (op == -1) {
                    if (x >= lastUp) {
                        isPossible = false;
                        break;
                    }
                    lastUp = x;
                }
            }

            if (!map.containsKey(1) || !map.containsKey(-1)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }


        }
        scanner.close();
    }
}