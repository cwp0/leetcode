package interview.vivo;

/**
 * @Program: Java
 * @Package: interview.vivo
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/13 15:01
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param memoryUsage int整型一维数组 数组 memoryUsage，其中 memoryUsage[i] 表示应用在第 i 秒的内存使用量（以MB为单位）
     * @param k int整型 整数k
     * @return int整型一维数组
     */
    public int[] findFluctuations (int[] memoryUsage, int k) {
        // write code here
        int n = memoryUsage.length;
        int [] res = new int[n-k+1];
        int resIndex = 0;
        // 存储最大值的pq
        PriorityQueue<int[]> pq_max = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        // 存储最小值的pq
        PriorityQueue<int[]> pq_min = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < n; i++) {
            pq_max.offer(new int[]{memoryUsage[i], i});
            pq_min.offer(new int[]{memoryUsage[i], i});

            while (pq_max.peek()[1] <= i-k) {
                pq_max.poll();
            }
            while (pq_min.peek()[1] <= i-k) {
                pq_min.poll();
            }

            if (i >= k-1) {
                res[resIndex++] = pq_max.peek()[0] - pq_min.peek()[0];
            }
        }
        return res;
    }
}