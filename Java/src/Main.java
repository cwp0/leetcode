import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> strs = new ArrayList<>();
        strs.isEmpty();
        strs.add("1");
        strs.size();
        strs.get(0);

        LinkedList<Integer> nums = new LinkedList<>();
        nums.isEmpty();
        nums.size();
        nums.contains(1);
        nums.add(1);
        nums.addFirst(2);
        nums.addLast(3);
        nums.remove(1);
        nums.removeFirst();
        nums.removeLast();



    }


}