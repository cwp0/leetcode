package interview.c360;

/**
 * @Program: Java
 * @Package: interview.c360
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/28 17:14
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        while (T-- > 0) {
            String equation = scanner.nextLine();
            if (isValid(equation)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isValid(String equation) {
        String[] sides = equation.split("=");
        String left = sides[0];
        String right = sides[1];
        // 如果两边相等，直接返回
        if (evaluate(left) == evaluate(right)) {
            return true;
        }

        // 循环对左边等式插入数字
        for (int pos = 0; pos <= left.length(); pos ++) {
            for (int digit = 0; digit <= 9; digit++) {
                String newLeft = left.substring(0, pos) + digit + left.substring(pos);
                if (evaluate(newLeft) == evaluate(right)) {
                    return true;
                }
            }
        }

        // 循环对右边数字插入等式
        for (int pos = 0; pos <= right.length(); pos++) {
            for (int digit = 0; digit <= 9; digit++) {
                String newRight = right.substring(0, pos) + digit + right.substring(pos);
                if (evaluate(left) == evaluate(newRight)) {
                    return true;
                }
            }
        }


        return false;
    }

    private static int evaluate(String expression) {
        String[] tokens = expression.split("(?<=\\D)|(?=\\D)");
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (token.trim().isEmpty()) continue;
            if (Character.isDigit(token.charAt(0))) {
                numbers.push(Integer.parseInt(token));
            } else {
                while (!operators.isEmpty() && pre(operators.peek()) >= pre(token.charAt(0))) {
                    int b = numbers.pop();
                    int a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(applyOp(a, b, op));
                }
                operators.push(token.charAt(0));
            }
        }

        while (!operators.isEmpty()) {
            int b = numbers.pop();
            int a = numbers.pop();
            char op = operators.pop();
            numbers.push(applyOp(a, b, op));
        }
        return numbers.pop();
    }

    private static int pre(char op) {
        return (op == '+' ? 1 : 2);
    }

    private static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+' : return a + b;
            case '*' : return a * b;
            default: throw new UnsupportedOperationException(op + "");
        }
    }
}