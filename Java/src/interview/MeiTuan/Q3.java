package interview.MeiTuan;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/13 11:24
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();

            double num = 1.0/N;

            int res = calculate(1, N);
            if (res == 0) {
                res = 1;
            }
            System.out.println(res);
        }
    }

    public static int calculate(int n, int m) {
        n = n % m;
        Vector<Integer> v = new Vector<>();

        for (;;) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) {
                return 0;
            }

            if (v.contains(n)) {
                return v.size() - v.indexOf(n);
            }

        }
    }

}