package interview.HuaWei;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.HuaWei
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/17 19:06
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        String[] cards = s.nextLine().split(" ");

        List<String> cardList = new ArrayList<>(Arrays.asList(cards));

        boolean changed;
        do {
            changed = removeConsecutiveTrioles(cardList);
        } while (changed);

        if (cardList.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(String.join(" ", cardList));
        }

    }

    private static boolean removeConsecutiveTrioles(List<String> cardList) {
        boolean changed = false;
        int i = 0;

        while (i < cardList.size() -2) {
            String currentCard = cardList.get(i);
            int count = 1;

            while (i + count < cardList.size() && cardList.get(i+count).equals(currentCard)) {
                count++;
            }

            if (count >= 3) {
                for (int j = 0; j < count; j++) {
                    cardList.remove(i);
                }
                changed = true;
                i = i;
            } else {
                i++;
            }

        }
        return changed;
    }

}