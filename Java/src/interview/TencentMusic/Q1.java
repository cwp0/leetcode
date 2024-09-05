package interview.TencentMusic;

/**
 * @Program: Java
 * @Package: interview.TencentMusic
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/05 19:01
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> newArray (ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : a) {
            String numStr = String.valueOf(num);
            String newNumStr = numStr.replaceAll("2", "");

            if (!newNumStr.isEmpty()) {
                res.add(Integer.parseInt(newNumStr));
            }
        }

        return res;
    }

}