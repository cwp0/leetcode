package interview.WangYi.YouDao;

/**
 * @Program: Java
 * @Package: interview.WangYi.YouDao
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/28 10:03
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            isValid(line);
        }
        scanner.close();
    }

    private static void isValid(String line) {
        Stack<Character> stack = new Stack<>();

        boolean valid = true;
        boolean isElement = true;
        int validPrefixLen = line.length();

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);

            if (current == '[') {
                if (!isElement) {
                    valid = false;
                    validPrefixLen = i;
                    break;
                }
                stack.push(current);
                isElement = true; // 下一个是元素
            } else if (current == ']') {
                if (stack.isEmpty()) {
                    valid = false;
                    validPrefixLen = i;
                    break;
                }
                stack.pop();
                isElement = false;
            } else if (current == ',') {
                if (isElement) {
                    valid = false;
                    validPrefixLen = i;
                    break;
                }
                isElement = true;
            } else if (Character.isLetterOrDigit(current)) {
                isElement = false;
            } else {
                valid = false;
                validPrefixLen = i;
                break;
            }
        }

        if (valid && stack.isEmpty() && !isElement) {
            System.out.println("valid");
        } else {
            if (validPrefixLen > 0) {
                System.out.println("invalid " + validPrefixLen);
            } else {
                System.out.println("invalid 0");
            }
        }


    }

}