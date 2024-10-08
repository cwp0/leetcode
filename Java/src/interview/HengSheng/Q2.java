package interview.HengSheng;

/**
 * @Program: Java
 * @Package: interview.HengSheng
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/26 19:28
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();

        if (c % 2 == 0) {
            long half = c / 2;
            System.out.println(half * half);
        } else {
            long half1 = c / 2;
            long half2 = half1 + 1;
            System.out.println(half1 * half2);
        }

    }
}