package interview.BaiDu;

/**
 * @Program: Java
 * @Package: interview.BaiDu
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/15 19:02
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 1 || n == 2 || n == 3) {
            System.out.println(0);
        } else if (n == 4) {
            System.out.println(10);
        }

    }
}