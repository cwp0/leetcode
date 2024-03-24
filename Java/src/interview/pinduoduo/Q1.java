package interview.pinduoduo;
/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: interview.pinduoduo.Q1
 * @Description: no
 * @Author: cwp0
 * @CreatedTime: 2024/03/24 19:14
 * @Version: 1.0
 */
import java.util.Arrays;
import java.util.Scanner;
public class Q1 {

    /*
    这里有 n 个正整数，a_1, ..., a_n
    Alice 会先去掉其中最多 d 个数
    Bob 接下来会将剩余的数中最多 m 个数乘以 -k
    Alice 想要剩余数之和尽可能大，Bob 想要剩余数之和尽可能小。假设 Alice 和 Bob 都足够聪明，请问最后剩余数之和是多少。

    输入描述：
    第一行一个正整数 T，接下来有 T 组数据
    每组数据 2 行
    第一行 4 个数 n, m, k, d \ (2 \leq n \leq 10^5)\ (0 \leq m,\ d \leq n)\ (1 \leq k \leq 10^4)
    第二行 n 个数，a_1, a_2, ... , a_n\ (1 \leq a_i \leq 10^9)

    保证 \sumn 不超过 10^5

    输出描述：
    每组数据输出一行，每行一个数，表示剩余数之和

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

            int maxSum = getMaxRemainSum(arr, m, d, k);
            System.out.println(maxSum);

        }

        scanner.close();
    }

    public static int getMaxRemainSum(int[] arr, int m, int d, int k) {
        Arrays.sort(arr); // 对数组进行排序，以便Alice去掉最大的d个数，Bob操作最小的m个数

        int[] reverseArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArray[i] = arr[arr.length - 1 - i];
        }

        // Alice 移除最多d个最大的数
        int remaining = reverseArray.length - d;

        // Bob 选择最多m个最小的数将其乘以-k
        for (int i = 0; i < Math.min(m, remaining); i++) {
            reverseArray[i] *= -k;
        }

        // 计算剩余数的和
        int sum = 0;
        for (int i = 0; i < remaining; i++) {
            sum += reverseArray[i];
        }
        return sum;
    }



}