package interview.vivo;

/**
 * @Program: Java
 * @Package: interview.vivo
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/13 15:01
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组 礼物的价格
     * @param k int整型 粉丝人数
     * @return bool布尔型
     */
    public boolean canEqualDistribution (int[] prices, int k) {
        // write code here
        int sum = Arrays.stream(prices).sum();
        if (sum % k != 0) return false;

        int target = sum / k;
        Arrays.sort(prices);

        if (prices[prices.length - 1] > target) return false;

        int[] buckets = new int[k];
        return backtrack(prices, buckets, prices.length-1, target);

    }

    public boolean backtrack(int[] prices, int[] buckets, int index, int target) {
        if (index < 0) {
            for (int bucket : buckets) {
                if (bucket != target) {
                    return false;
                }
            }
            return true;
        }

        int price = prices[index];

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + price > target) {
                continue;
            }

            buckets[i] += price;
            if (backtrack(prices, buckets, index-1, target)) {
                return true;
            }
            buckets[i] -= price;
            if (buckets[i] == 0) {
                break;
            }

        }

        return false;
    }


    public static void main(String[] args) {

    }
}