package interview.BaiDu;

/**
 * @Program: Java
 * @Package: interview.BaiDu
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/15 19:02
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        StringBuilder res = new StringBuilder(s);

        for (int i = 1; i <= n; i++) {
            char c = res.charAt(i-1);
            res.deleteCharAt(i-1);
            res.append(c);
        }


        System.out.println(res);
    }
}