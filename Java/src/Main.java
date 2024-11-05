/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: Main
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/04 13:48
 * @Version: 1.0
 */
import java.util.Arrays;

public class Main {

    // 从指定数字集合中找小于等于给定数的最大值
    public static int getLargest(int[] digits, int limit) {
        int result = -1;
        for (int digit : digits) {
            if (digit <= limit) {
                result = Math.max(result, digit);
            }
        }
        return result;
    }

    // 返回用 digits 中的数字构造的，不超过 n 的最大数字
    public static String findMax(int[] digits, String n) {
        char[] nArray = n.toCharArray();
        int length = nArray.length;
        char[] result = new char[length];
        boolean hasSmaller = false;

        // 排序 digits 方便后面处理
        Arrays.sort(digits);

        for (int i = 0; i < length; i++) {
            int limit = nArray[i] - '0';
            int largest = getLargest(digits, limit);

            if (largest == -1) {
                // 找不到合适的数字，回退
                int j = i - 1;
                while (j >= 0 && result[j] == (char)(digits[0] + '0')) {
                    j--;
                }

                if (j < 0) {
                    // 找不到合适的结果，只能用最大数字构造小一位的数字
                    char[] newResult = new char[length - 1];
                    Arrays.fill(newResult, (char)(digits[digits.length - 1] + '0'));
                    return new String(newResult);
                }

                result[j] = (char)(getLargest(digits, result[j] - '0' - 1) + '0');
                for (int k = j + 1; k < length; k++) {
                    result[k] = (char)(digits[digits.length - 1] + '0');
                }
                return new String(result);
            }

            result[i] = (char)(largest + '0');
            if (largest < limit) {
                // 如果找到比当前位小的数字，后续位可以用最大数字填充
                for (int j = i + 1; j < length; j++) {
                    result[j] = (char)(digits[digits.length - 1] + '0');
                }
                return new String(result);
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        int[] digits = {2, 4, 7}; // 给定的数字
        String n = "27221";        // 给定的数字 n

        String result = findMax(digits, n);
        System.out.println(result); // 输出：24777
    }
}
