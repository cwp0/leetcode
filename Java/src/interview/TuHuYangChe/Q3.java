package interview.TuHuYangChe;

/**
 * @Program: Java
 * @Package: interview.TuHuYangChe
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/10 19:07
 * @Version: 1.0
 */
public class Q3 {
    public int reviewAttendance (int days) {
        // write code here
        int MOD = 1000000007;

        // dp[i][j][k]表示前i填缺勤j次连续迟到k次的情况数量。
        int[][][] dp = new int[days + 1][2][3];

        dp[0][0][0] = 1;
        for (int i = 1; i <= days; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % MOD;

                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i-1][j-1][k]) % MOD;
                    }

                    if (k < 2) {
                        dp[i][j][k+1] = (dp[i][j][k+1] + dp[i-1][j][k]) % MOD;
                    }

                }
            }
        }

        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[days][j][k]) % MOD;
            }
        }

        return res;
    }
}