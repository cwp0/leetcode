package interview.GaoDe;

/**
 * @Program: Java
 * @Package: interview.GaoDe
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/10 19:00
 * @Version: 1.0
 */
public class Q1 {

    public boolean carPoolReserve (int[][] carpool_travels, int total_seat_count) {
        int maxStation = 0;
        for (int[] travel : carpool_travels) {
            maxStation = Math.max(maxStation, travel[2]);
        }

        int[] seats = new int[maxStation + 1];

        for (int[] travel : carpool_travels) {
            int count = travel[0];
            int from = travel[1];
            int to = travel[2];
            seats[from] -= count;
            seats[to] += count;
        }

        int currentSeats = total_seat_count;
        for (int seat : seats) {
            currentSeats += seat;
            if (currentSeats < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}