package interview.YongYou;

/**
 * @Program: Java
 * @Package: interview.YongYou
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/16 19:03
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {

    }

    public int[] favoriteSongs (int[] songs, int k) {
        // write code here
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int song : songs) {
            countMap.put(song, countMap.getOrDefault(song, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedSongs = new ArrayList<>
                (countMap.entrySet());
        Collections.sort(sortedSongs, (a, b) -> {
            return b.getValue() - a.getValue();
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = sortedSongs.get(i).getKey();
        }
        Arrays.sort(res);
        return res;
    }

}