package interview.HW;

/**
 * @Program: Java
 * @Package: interview.HW
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/14 20:56
 * @Version: 1.0
 */
import java.util.*;

public class Q1 {
    // 内部类，用于表示任务和其超时时刻的索引
    static class Task {
        int time;
        int index;

        Task(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入
        int n = sc.nextInt();  // 定时器容量
        int m = sc.nextInt();  // 任务数量
        int[] tasks = new int[m];  // 超时时刻

        for (int i = 0; i < m; i++) {
            tasks[i] = sc.nextInt();
        }

        // 定时器任务管理：队列保存超时时刻和任务的索引
        Deque<Task> timer = new LinkedList<>();

        // 记录队列中的任务
        for (int i = 0; i < m; i++) {
            int time = tasks[i];

            // 如果定时器未满，直接添加任务
            if (timer.size() < n) {
                timer.offer(new Task(time, i));
            } else {
                // 如果定时器已满，查看任务超时刻是否符合条件
                Task lastTask = timer.peekLast(); // 获取队列中最晚的超时任务
                if (time <= lastTask.time) {
                    timer.pollLast(); // 移除最晚超时任务
                    timer.offer(new Task(time, i)); // 添加新任务
                }
            }
        }

        // 输出队列中最后一个超时任务的索引
//        int lastTaskIndex = -1;
//        while (!timer.isEmpty()) {
//            lastTaskIndex = timer.poll().index;
//        }

        System.out.println(timer.peekLast().index);
    }
}

/*
Java ACM模式解题
有一个定时器系统：
1. 该系统精度为1刻度、可容纳n个超时任务；
2. 每个人屋里包含该任务超时时刻t(当系统时钟到达t时，该任务开始执行)，t为正整数；
3. 同一时刻超时的任务按照加入系统的先后顺序依次执行超时任务;
4. 当定时器中任务不足n个时候，可以直接添加新任务；
5. 当定时器中任务数达到n个时候，假定待添加任务的超时时刻为ti，系统中最后执行的任务的超时时刻为tj，如果ti>tj，则丢弃待添加的任务，否则丢弃系统中最晚执行的超时任务，并将待添加任务加入系统中。

现在给定定时器容量n，短时间内(不到1刻度)依次向该系统添加m个定时任务tasks，假定当前时钟为0时刻，即添加的任务都是未超时任务，且都是一次性定时任务。

输出该定时器系统中最后超时的任务索引号，即：当前task在tasks中的下标(下标从0开始)，如果多个任务同时超时，则输出最大的索引号。

输入描述
第一行 容量n， 1<=n<=1000
第二行 任务个数m， 1<=m<=1000000
第三行 m个正整数，表示任务超时时刻，1<=ti<=100000


输出描述
输出最后超时的任务索引号

样例输入
2
12
1 2 3 4 6 19 20 21 22 23 24 1
样例输出
11
说明：
容量为2，最终定时器只会有两个任务，分别为1(索引为0), 1(索引为11)，这两个任务同时超时，返回更大的任务索引号为11
*/
