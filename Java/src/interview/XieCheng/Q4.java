package interview.XieCheng;

/**
 * @Program: Java
 * @Package: interview.XieCheng
 * @Class: Q4
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/29 16:37
 * @Version: 1.0
 */

/*
游游希望你输出n个"you"，第一个正序输出，第二个倒序，第三个正序……以此类推。你能帮帮她吗？

Java ACM模式

1 <= n <= 10^5
 */
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        String str = "you";

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(str);
            } else {
                System.out.print(reverseString(str));
            }

            if (i < n) {
                System.out.print(" ");
            }
        }
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
