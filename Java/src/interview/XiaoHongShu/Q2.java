package interview.XiaoHongShu;

/**
 * @Program: Java
 * @Package: interview.XiaoHongShu
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/14 16:00
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int k = scanner.nextInt();

            List<int[]> dimensions = findDimensions(k);

            int res = 0;
            for (int[] dim : dimensions) {
                int a = dim[0], b = dim[1], c = dim[2];
                res = Math.max(res, countPos(x, y, z, a, b, c));
            }
            System.out.println(res);
        }
        scanner.close();
    }

    public static int countPos(int x, int y, int z, int a, int b, int c) {
        int res = 0;
        int[][] pos = {
                {a, b, c},
                {a, c, b},
                {b, a, c},
                {b, c, a},
                {c, a, b},
                {c, b, a}
        };

        for (int[] p : pos) {
            if (p[0] <= x && p[1] <= y && p[2] <= z) {
                int ways = (x - p[0] + 1) * (y - p[1] + 1) * (z - p[2] + 1);
                res = Math.max(res, ways);
            }
        }

        return res;
    }


    // 根据体积寻找可能的边长
    public static List<int[]> findDimensions(int k) {
        List<int[]> dimensions = new ArrayList<>();
        for (int a = 1; a * a * a <= k; a++) {
            if (k % a == 0) { // 整数分配
                int remain = k / a;
                for (int b = 1; b * b <= remain; b++) {
                    if (remain % b == 0) { // 整数分配
                        int c = remain / b;
                        dimensions.add(new int[]{a, b, c});
                    }
                }
            }
        }
        return dimensions;
    }
}