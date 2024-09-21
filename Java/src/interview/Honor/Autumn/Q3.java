package interview.Honor.Autumn;

/**
 * @Program: Java
 * @Package: interview.Honor.Autumn
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/21 18:59
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    static class Task {
        String id;
        int acceptTime;
        int minPeople;
        int devTime;
        public Task(String id, int acceptTime, int minPeople, int devTime) {
            this.id = id;
            this.acceptTime = acceptTime;
            this.minPeople = minPeople;
            this.devTime = devTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] teamSize = scanner.nextLine().split("\\|");
        int size = teamSize.length;
        int[] teams = new int[size];
        for (int i = 0; i < size; i++) {
            teams[i] = Integer.parseInt(teamSize[i]);
        }

        List<Task> tasks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");
//            System.out.println(parts.length);
            if (parts.length != 4) {
                break;
            }
            String id = parts[0];
            int acceptTime = Integer.parseInt(parts[1]);
            int minPeople = Integer.parseInt(parts[2]);
            int devTime = Integer.parseInt(parts[3]);
            tasks.add(new Task(id, acceptTime, minPeople, devTime));


        }
        scanner.close();


        // 按照时间和编号排序
        tasks.sort((t1, t2) -> {
            if (t1.acceptTime != t2.acceptTime) {
                return t1.acceptTime - t2.acceptTime;
            } else {
                return t1.id.compareTo(t2.id);
            }
        });


        int[] availableTime = new int[size];

        PriorityQueue<Integer> availableTeams = new PriorityQueue<>(Comparator.comparing(i -> availableTime[i]));

        for (Task task : tasks) {
            availableTeams.clear();
            for (int i = 0; i < size; i++) {
                if (teams[i] >= task.minPeople) {
                    availableTeams.offer(i);
                }
            }

            if (!availableTeams.isEmpty()) {
                int choise = availableTeams.poll();
                int startTime = Math.max(task.acceptTime, availableTime[choise]);
                double temp = (double) task.minPeople / teams[choise];
                int autualTime = (int) Math.ceil(task.devTime * temp);

                availableTime[choise] = startTime + autualTime;
                System.out.println(task.id + "|" + (choise + 1) + "|" + startTime + "|" + autualTime);
            }


//            int startTime = Integer.MAX_VALUE;
//            int choise = -1;
//
//            for (int i = 0; i < size; i++) {
//                if (teams[i] >= task.minPeople && availableTime[i] <= task.acceptTime) {
//                    if (availableTime[i] < startTime) {
//                        startTime = availableTime[i];
//                        choise = i;
//                    }
//                }
//            }
//            if (choise != -1) {
//
//                int autualTime = (int)Math.ceil((double)task.minPeople / (teams[choise] / (double) task.devTime));
//                int finalStartTime = Math.max(task.acceptTime, availableTime[choise]);
//
//                availableTime[choise] = finalStartTime + autualTime;
//
//                System.out.println(task.id + "|" + (choise + 1) + "|" + finalStartTime + "|" + autualTime);
//            }
        }
    }
}