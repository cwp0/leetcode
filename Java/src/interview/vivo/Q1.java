package interview.vivo;

/**
 * @Program: Java
 * @Package: interview.vivo
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/13 15:01
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 获取最小分组数
     * @param staff int整型一维数组 员工数组，其中0表示新员工，1表示老员工
     * @return int整型
     */
    public int staffGroup (int[] staff) {
        // write code here
        int n = staff.length;
        int i = 0;
        int groupCount = 0;
        while (i < n) {
            if (staff[i] == 1) {
                groupCount++;
                if (i + 1 < n && staff[i+1] == 0) {
                    i += 2;
                } else {
                    i++;
                }
            } else {
                groupCount++;
                if (i + 2 < n && staff[i+1] == 0 && staff[i+2] == 0) {
                    i += 3;
                } else if (i + 1 < n && staff[i+1] == 0) {
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        return groupCount;
    }
    public static void main(String[] args) {

    }
}