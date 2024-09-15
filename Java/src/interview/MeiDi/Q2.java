package interview.MeiDi;

/**
 * @Program: Java
 * @Package: interview.MeiDi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/15 14:40
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        for (int num = 100; num <= 999; num++) {
            int hundred = num / 100;
            int ten = (num / 10) % 10;
            int one = num % 10;

            int sum = (int)(Math.pow(hundred, 3) + Math.pow(ten, 3) + Math.pow(one, 3));

            if (sum == num) {
                System.out.println(num);
            }

        }
    }
}