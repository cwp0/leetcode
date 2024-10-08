package interview.Shopee;

/**
 * @Program: Java
 * @Package: interview.Shopee
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/08 16:04
 * @Version: 1.0
 */


public class Q2 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param steps int整型 一维数组
     * @return int整型
     */
    public int jump(int[] steps) {
        int jump = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < steps.length - 1; i++) {
            farthest = Math.max(farthest, i+steps[i]);

            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;

                if (currentEnd >= steps.length - 1) {
                    break;
                }

            }


        }
        return jump;
    }





    public static void main(String[] args) {

    }
}