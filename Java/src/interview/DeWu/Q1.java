package interview.DeWu;

/**
 * @Program: Java
 * @Package: interview.DeWu
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/11 10:01
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();

            if (!canFormTriangle(x, y, z)) {
                System.out.println("Cannot form a triangle");
            } else if (isSimilar(a, b, c, x, y, z)) {
                System.out.println("similar");
            } else {
                System.out.println("Can form a triangle but not similar");
            }

        }
        scanner.close();
    }

    public static boolean canFormTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static boolean isSimilar(int a, int b, int c, int x, int y, int z) {
        int[] tri1 = {a, b, c};
        int[] tri2 = {x, y, z};
        Arrays.sort(tri1);
        Arrays.sort(tri2);

        return tri1[0] * tri2[1] == tri1[1] * tri2[0] && tri1[0] * tri2[2] == tri1[2] * tri2[0];

    }

}