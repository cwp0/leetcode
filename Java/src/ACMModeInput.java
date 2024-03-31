import java.util.*;

/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: ACMModeInput
 * @Description: ACM模式下做题的输入处理方式。
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 19:47
 * @Version: 1.0
 */
public class ACMModeInput {

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * 第一行一个正整数 T，接下来有 T 组数据
         * 每组数据 2 行
         * 第一行 4 个数 n, m, k, d
         * 第二行 n 个数，a_1, a_2, ... , a_n
         */
        /*
3
6 2 3 4
5 6 7 8 9 0 1
6 2 3 4
5 6 7 8 9 0 1
6 2 3 4
5 6 7 8 9 0 1
         */
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            int k = scanner.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // 处理每组数据

        }

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        /**
         * 输入有三行，第一行2个数m和n，为A和B的长度；
         * 第二行为长度为m的A串
         * 第三行为长度为n的B串，A和B仅由'0'和'1'组成
         */
        /*
8 2
10100000
10
         */
        int m1 = scanner.nextInt();
        int n1 = scanner.nextInt();
        scanner.nextLine(); // 使用nextInt()后如果需要按行取数据，要接nextLine()换行
        String A = scanner.nextLine();
        String B = scanner.nextLine(); // nextLine() 返回的是字符串

        // 处理数据

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        /**
         * 第一行, 包含一个正整数 T1 代表测试数据的组数.
         * 接下来 T1 行是测试数据，对于每组测试数据, 仅有一行, 代表这个字符串.
         */
        /*
3
mwapd
tvuvv
yxxmi
         */
        int T1 = scanner.nextInt();
        scanner.nextLine(); // 使用nextInt()后如果需要按行取数据，要接nextLine()换行
        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();

            // 处理数据

        }


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        /*
3 3
1 2 3
1 2 3
1 2 3
RPR
PRP
RPR
         */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] values = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                values[i][j] = scanner.nextInt();
            }
        }

        scanner.nextLine(); // 注意 这里的关键是这里nextInt()后的换行。

        char[][] colors = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                colors[i][j] = line.charAt(j); // 因为每一行是字符串，所以可以用charAt()来处理输入并存入char[][]数组。
                System.out.println(colors[i][j]);
            }
        }






        scanner.close(); // 处理完输入后记得关闭
    }


}
