package interview.pinduoduo;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: interview.pinduoduo.Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/24 19:59
 * @Version: 1.0
 */
public class Q2 {
    /*
    伊文有两个由0和1组成的字符串，A和B，长度分别为m和n(m>=n)。伊文希望取出A的连续子串与B构造若干长度为n的S串，满足：
    Si=Ax+i⊕Bi,  i∈[1,n], x∈[0,m-n]
    S1⊕S2⊕S3⊕...⊕Sn-1⊕Sn=0
    ⊕代表异或运算
    伊文想知道总共能够构造出多少个不同的S串。

    输入有三行，第一行2个数m和n，为A和B的长度；
    m,n\ \ (0<n\leq m\leq 5\times10^3)
    第二行为长度为的A串
    第三行为长度为的B串，A和B仅由'0'和'1'组成

    输出：一个数字，代表不同的S串个数

    样例：
    输入：
    8 2
    10100000
    10
    输出：
    2
    说明：
    符合条件的S串为["00","11"]，分别由A的子串["10","01"]与B串得到
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String A = scanner.nextLine();
        String B = scanner.nextLine();

        int count = 0;
        for (int i = 0; i <= m - n; i++) {
            String subA = A.substring(i, i + n);
            String subB = B;
            if (isS(subA, subB)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isS(String subA, String subB) {
        int sum = 0;
        for (int i = 0; i < subA.length(); i++) {
            sum += (subA.charAt(i) - '0') ^ (subB.charAt(i) - '0');
        }
        return sum == 0;
    }




}