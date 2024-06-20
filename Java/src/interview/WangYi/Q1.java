package interview.WangYi;

/**
 * @Program: Java
 * @Package: interview.WangYi
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/06/20 19:37
 * @Version: 1.0
 */

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[5];
        int[] b = new int[5];
        int[] c = new int[5];
        int[] d = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            c[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            d[i] = scanner.nextInt();
        }

        int yiCurrent = 0;
        int oppoCurrent = 0;
        while (yiCurrent < 5 && oppoCurrent < 5) {
            // 小易攻击对手
            d[oppoCurrent] -= a[yiCurrent];
            if (d[oppoCurrent] <= 0) {
                oppoCurrent++;
                if (oppoCurrent >= 5) {
                    break;
                }
            }

            // 对手攻击小易
            b[yiCurrent] -= c[oppoCurrent];
            if (b[yiCurrent] <= 0) {
                yiCurrent++;
            }
        }

        if (oppoCurrent >= 5) {
            System.out.println("win");
            System.out.println(5 - yiCurrent);
        } else {
            System.out.println("lose");
            System.out.println(5 - oppoCurrent);
        }
    }
}