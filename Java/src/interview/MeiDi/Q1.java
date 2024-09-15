package interview.MeiDi;

/**
 * @Program: Java
 * @Package: interview.MeiDi
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/15 14:40
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    static Map<Character, Integer> ori = new HashMap<>();
    static Map<Character, Integer> cnt = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanenr = new Scanner(System.in);
        String M = scanenr.nextLine();
        String N = scanenr.nextLine();
        scanenr.close();

        int mLen = M.length();
        int nLen = N.length();

        for (int i = 0; i < nLen; i++) {
            char c = N.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        // 滑动窗口
        while (right < mLen) {
            ++right;
            if (right < mLen && ori.containsKey(M.charAt(right))) {
                cnt.put(M.charAt(right), cnt.getOrDefault(M.charAt(right), 0) + 1);
            }
            // 缩小窗口条件
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (ori.containsKey(M.charAt(left))) {
                    cnt.put(M.charAt(left), cnt.getOrDefault(M.charAt(left), 0) - 1);
                }
                ++left;
            }
        }
        String res = ansL == -1 ? "" : M.substring(ansL, ansR);
        System.out.println(res);

    }
    public static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}