import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] target = {1,2};
        int n = 4;
        System.out.println(TAMPLATE(target, n));
    }

    public static List<String> TAMPLATE(int[] target, int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j == target.length) {
                break;
            }
            if (i == target[j]) {
                list.add("\"Push\"");
                j++;
            } else {
                list.add("\"Push\"");
                list.add("\"Pop\"");
            }
        }
        return list;
    }

}