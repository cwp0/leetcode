package autumn.JingDong;

/**
 * @Program: Java
 * @Package: autumn.JingDong
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 16:02
 * @Version: 1.0
 */
import java.math.BigInteger;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger N = scanner.nextBigInteger();

        if (N.compareTo(BigInteger.ZERO) < 0) {
            System.out.println(0);
        } else {
            BigInteger count = N.divide(BigInteger.valueOf(100));
            System.out.println(count);
        }

    }
}