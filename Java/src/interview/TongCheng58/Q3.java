package interview.TongCheng58;

/**
 * @Program: Java
 * @Package: interview.TongCheng58
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/20 19:12
 * @Version: 1.0
 */
public class Q3 {
    private static final int MOD = 1000000007;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param startPos int整型
     * @param endPos int整型
     * @param k int整型
     * @return int整型
     */
    public int numberOfWays (int startPos, int endPos, int k) {
        // write code here
        int distance = Math.abs(endPos - startPos);

        // 如果k不够或者k与distance的奇偶性不同，肯定不能达到endPos
        if (distance > k || (k - distance) % 2 != 0) {
            return 0;
        }

        // 向右rigth步，向左left步
        // right + left = k
        // right - left = distance
        int right = (k + distance) / 2;
        // 向右走right步有多少种方案。
        return count(k, right);
    }

    private int count(int k, int right) {
        if (right > k) return 0; // 不能走
        if (right == 0 || right == k) return 1; // 只能向左走或者向右走。

        long[] dp = new long[right+1]; // 向右走0步有一种方案
        dp[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = Math.min(i, right); j > 0; j--) {
                dp[j] = (dp[j] + dp[j-1]) % MOD;
            }
        }
        return (int)dp[right];
    }
}