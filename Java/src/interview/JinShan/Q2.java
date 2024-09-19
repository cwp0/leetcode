package interview.JinShan;

/**
 * @Program: Java
 * @Package: interview.JinShan
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/18 19:04
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        String str = String.valueOf(a);
        StringBuilder str1 = new StringBuilder(str).reverse();
        System.out.println(str1);
    }
}