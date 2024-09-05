package autumn.MeiTuan;

/**
 * @Program: Java
 * @Package: autumn.MeiTuan
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 10:01
 * @Version: 1.0
 */

import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long k = scanner.nextLong();
        scanner.close();

        long mod = 1000000007;

        long[] arr = {a, b , c};
        Arrays.sort(arr);

        long avgInc = (k + 2) / 3;

        arr[0] += avgInc;
        k -= avgInc;
        if (k > 0) {
            avgInc = (k+1) / 2;
            arr[1] += avgInc;
            k -= avgInc;
            if (k > 0) {
                arr[2] += k;
            }
        }

        long res = ((arr[0] % mod) * (arr[1] % mod) * (arr[2] % mod)) % mod;
        System.out.println(res);
    }

}