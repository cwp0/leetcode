package interview.TencentYunZhi;

/**
 * @Program: Java
 * @Package: interview.TencentYunZhi
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/07/02 19:49
 * @Version: 1.0
 */

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        int res = 0;
        for (int i = 0; i <= b; i++) {
            int xorVar = a ^ i;
            if (xorVar > res) {
                res = xorVar;
            }
        }

        System.out.println(res);
    }

}