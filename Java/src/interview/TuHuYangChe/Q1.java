package interview.TuHuYangChe;

/**
 * @Program: Java
 * @Package: interview.TuHuYangChe
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/10 19:07
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

    }
    public boolean soldSolution (int[] moneyArrays) {
        // write code here
        int five = 0, ten = 0;

        for (int money : moneyArrays) {
            if (money == 5) {
                five++;
            } else if (money == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (money == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}