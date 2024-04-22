package interview.MiHoYo;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MiHoYo
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/21 20:41
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int index = 0;
        double res = (double) a[0]/b[0];
        for (int i = 1; i < n; i++) {
            if ((double)a[i]/b[i] > res) {
                index = i;
                res = (double)a[i]/b[i];
            }
        }
        System.out.println(index+1);
    }


}