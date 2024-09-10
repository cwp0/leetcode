package interview.GaoDe;

/**
 * @Program: Java
 * @Package: interview.GaoDe
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/10 19:01
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replace(" ", "");
        String [] arrays = input.split("\\]\\[");

        arrays[0] = arrays[0].replace("[", "");
        arrays[1] = arrays[1].replace("]", "");

        List<Integer> list1 = parseList(arrays[0]);
        List<Integer> list2 = parseList(arrays[1]);
        System.out.println(mergeLists(list1, list2).toString().replace(" ", ""));
    }

    private static List<Integer> mergeLists(List<Integer> list1,
                                            List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            res.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            res.add(list2.get(j));
            j++;
        }

        return res;
    }

    private static List<Integer> parseList(String input) {
        List<Integer> list = new ArrayList<>();
        if (!input.isEmpty()) {
            String[] elements = input.split(",");
            for (String e : elements) {
                if (!e.isEmpty()) {
                    list.add(Integer.parseInt(e));
                }
            }
        }

        return list;
    }

}