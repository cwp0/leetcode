package interview.HeMa;

/**
 * @Program: Java
 * @Package: interview.HeMa
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/09 19:01
 * @Version: 1.0
 */
import java.io.*;
import java.util.*;
public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x == 0) {
                bw.write("2\n");
            } else {
                int highestOneBit = Integer.highestOneBit(x);
                int mask = (highestOneBit << 1) - 1;
                int count = Integer.bitCount(~x & mask);
                bw.write((1 << count) + "\n");
            }
        }
        bw.close();
        bw.close();
        br.close();

    }
}