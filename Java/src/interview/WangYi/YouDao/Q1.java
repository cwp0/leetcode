package interview.WangYi.YouDao;

/**
 * @Program: Java
 * @Package: interview.WangYi.YouDao
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/28 10:03
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] words = input.split(" ");
        Set<String> seen = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (!seen.contains(word)) {
                seen.add(word);
                res.add(word);
            }
        }

        Collections.sort(res);

        StringBuilder stringBuilder= new StringBuilder();
        for (String word : res) {
            stringBuilder.append(word).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}