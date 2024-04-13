package interview.MeiTuan;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/13 10:35
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            long l = in.nextLong();
            long r = in.nextLong();

            if ((r - l + 1) % 2 == 0) {
                System.out.println(-1 * (r - l + 1)/2);
            } else {
                if (l % 2 == 0) {
                    System.out.println(-1 * (r - l)/2 - l);
                } else {
                    System.out.println(-1 * (r - l)/2 + r);
                }
            }

        }
    }
}