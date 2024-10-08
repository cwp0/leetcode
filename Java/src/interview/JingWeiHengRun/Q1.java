package interview.JingWeiHengRun;

/**
 * @Program: Java
 * @Package: interview.JingWeiHengRun
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/29 15:10
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

    }

    public int candy(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

}