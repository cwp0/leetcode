package interview.ShuZiMaLi;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.ShuZiMaLi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/08 19:29
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] parts = str.split("(?<=ali)/(?=ali)");
            String[] arr = new String[parts.length];
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < parts.length; i++) {
                if ("ali".equalsIgnoreCase(parts[i])) {
                    arr[i] = parts[i];
                } else {
                    arr[i] = new StringBuilder(parts[i]).reverse().toString().toUpperCase();
                }
            }

            for (int i = parts.length - 1; i >= 0; i--) {
                res.append(arr[i]);
            }
            System.out.println(str + " -> " + res);
        }


    }
}