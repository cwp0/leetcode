package interview.WangYi.LeiHuo;

/**
 * @Program: Java
 * @Package: interview.WangYi.LeiHuo
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/11 14:08
 * @Version: 1.0
 */
import java.util.*;

class Data {
    String name;
    int sort1;
    int sort2;
    public Data(String name, int sort1, int sort2) {
        this.name = name;
        this.sort1 = sort1;
        this.sort2 = sort2;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String orderBy = scanner.next();
        String orderType = scanner.next();
        scanner.close();

        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("ace", 8, 4));
        dataList.add(new Data("bre", 2, 3));
        dataList.add(new Data("cat", 5, 2));
        dataList.add(new Data("dog", 1, 1));

        Comparator<Data> comparator = null;
        if ("sort1".equals(orderBy)) {
            comparator = Comparator.comparingInt(d -> d.sort1);
        } else if ("sort2".equals(orderBy)) {
            comparator = Comparator.comparingInt(d -> d.sort2);
        }

        if (!"asc".equals(orderType)) {
            comparator = comparator.reversed();
        }

        dataList.sort(comparator);
        for (Data data : dataList) {
            System.out.println(data.toString());
        }
    }
}