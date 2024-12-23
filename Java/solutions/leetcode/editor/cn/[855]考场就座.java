// 
// @Question: [855]考场就座 
// @Author: cwp0
// @CreatedTime: 2024-12-23 12:53:08
// @Description: 
//在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。 
//
// 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，
//那么学生就坐在 0 号座位上。) 
//
// 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位
//置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在
//座位 p 上。 
//
// 
//
// 示例： 
//
// 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[]
//,[4],[]]
//输出：[null,0,9,4,2,null,5]
//解释：
//ExamRoom(10) -> null
//seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
//seat() -> 9，学生最后坐在 9 号座位上。
//seat() -> 4，学生最后坐在 4 号座位上。
//seat() -> 2，学生最后坐在 2 号座位上。
//leave(4) -> null
//seat() -> 5，学生最后坐在 5 号座位上。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。 
// 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。 
// 
//
// Related Topics 设计 有序集合 堆（优先队列） 👍 283 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom {
    int n;
    TreeSet<Integer> seats;
    PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<Integer>();
        this.pq = new PriorityQueue<int[]>((a, b) -> {
            int d1 = a[1] - a[0], d2 = b[1] - b[0];
            return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first(), right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            int[] p = pq.peek();
            if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                int d = p[1] - p[0];
                if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                    break;
                }
                pq.poll();
                pq.offer(new int[]{p[0], p[0] + d / 2});
                pq.offer(new int[]{p[0] + d / 2, p[1]});
                seats.add(p[0] + d / 2);
                return p[0] + d / 2;
            }
            pq.poll(); // leave 函数中延迟删除的区间在此时删除
        }
        if (right > left) { // 最右的位置更优
            pq.offer(new int[]{seats.last(), n - 1});
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.offer(new int[]{0, seats.first()});
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            int prev = seats.lower(p), next = seats.higher(p);
            pq.offer(new int[]{prev, next});
        }
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)

