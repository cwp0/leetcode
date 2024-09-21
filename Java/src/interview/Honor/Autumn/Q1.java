package interview.Honor.Autumn;

/**
 * @Program: Java
 * @Package: interview.Honor.Autumn
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/21 18:58
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bytes = scanner.nextLong();
        scanner.close();
        System.out.println(convert(bytes));
    }

    private static String convert(long bytes) {
        if (bytes < 1024) {
            return bytes + "B";
        }
        double size = bytes / 1024.0;
        String[] units = {"KB", "MB", "GB"};
        int index = 0;

        while (size >= 1024 && index < units.length - 1) {
            size /= 1024;
            index++;
        }
        return String.format("%.2f%s", size, units[index]);
    }
}