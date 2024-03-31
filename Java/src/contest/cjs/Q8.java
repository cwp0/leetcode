package contest.cjs;

import java.util.Scanner;
import java.lang.StringBuilder;

/**
 * @Program: Java
 * @Package: contest.cjs
 * @Class: Q8
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 09:16
 * @Version: 1.0
 */



public class Q8 {
    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        String s1 = s.substring(0, 3);
        String s2 = s.substring(3);

        String newStr = s2 + s1;

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < newStr.length(); i++) {
            int asc = (int)newStr.charAt(i);
            res.append(asc);
        }
        System.out.println(res);
    }

}