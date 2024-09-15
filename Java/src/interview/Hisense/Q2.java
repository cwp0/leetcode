package interview.Hisense;

/**
 * @Program: Java
 * @Package: interview.Hisense
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/15 19:22
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {

    }

    public int uppercase (String str) {
        // write code here
        int res = 0;

        String vowels = "AEIOU";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c) && vowels.indexOf(c) != -1) {
                res++;
            } else if (Character.isLowerCase(c) && !vowels.toLowerCase().contains(String.valueOf(c))) {
                res++;
            }
        }

        return res;
    }

}