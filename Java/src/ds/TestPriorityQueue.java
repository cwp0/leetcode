package ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Program: Java
 * @Package: ds
 * @Class: TestPriorityQueue
 * @Description: 学习PriorityQueue的一些用法
 * @Author: cwp0
 * @CreatedTime: 2024/03/30 15:52
 * @Version: 1.0
 */
public class TestPriorityQueue {
    /**
     * 1. 使用时必须导入 PriorityQueue 所在的包
     *      import java.util.PriorityQueue;
     * 2. PriorityQueue 中放置的 元素必须要能够比较大小，不能插入无法比较大小的对象 ，否则会抛出 ClassCastException异常
     * 3. 不能插入null对象 ，否则会抛出 NullPointerException
     * 4. 没有容量限制，可以插入任意多个元素，其内部可以自动扩容
     * 5. 插入和删除元素的时间复杂度为O(logN)
     * 6. PriorityQueue 底层使用了 堆数据结构
     * 7. PriorityQueue 默认情况下是小堆 --- 即每次获取到的元素都是最小的元素
     */

    public static void main(String[] args) {
        // 创建一个空的优先级队列，底层默认容量是11
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        // 创建一个空的优先级队列，指定底层容量
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(100);

        // 用ArrayList对象来构造一个优先级队列的对象
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(list);
        // 尺寸
        System.out.println("最小堆pq3中的尺寸为：" + pq3.size());
        // 获取优先级最高的元素，也就是最小堆的最小元素
        System.out.println("pq3中优先级最高的元素为：" + pq3.peek());

        // 如果需要最大堆，则需要自己构建比较器。
        PriorityQueue<Integer> pq4 = new PriorityQueue<>(new IntCmp());
        pq4.offer(4);
        pq4.offer(3);
        pq4.offer(2);
        pq4.offer(1);
        pq4.offer(5);
        // 获取优先级最高的元素，也就是最大堆的最大元素
        System.out.println("最小堆pq4中优先级最高的元素为：" + pq4.peek());

        // 也可以使用lambda表达式创建最大堆。 下面三种方式都可以：
        // PriorityQueue<Integer> pq5 = new PriorityQueue<Integer>((o1, o2) -> {return o2 - o1;});
        // PriorityQueue<Integer> pq5 = new PriorityQueue<>((Integer o1, Integer o2) -> {return o2 - o1;});
        PriorityQueue<Integer> pq5 = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        pq5.offer(4);
        pq5.offer(3);
        pq5.offer(2);
        pq5.offer(1);
        pq5.offer(5);
        System.out.println("最大堆pq5中优先级最高的元素为：" + pq5.peek());

        // 常用方法：

        int[] arr = {4,1,9,2,8,0,7,3,6,5};
        // 一般在创建优先级队列对象时，如果知道元素个数，建议就直接将底层容量给好
        // 否则在插入时需要不多的扩容
        // 扩容机制：开辟更大的空间，拷贝元素，这样效率会比较低
        PriorityQueue<Integer> pq6 = new PriorityQueue<>(arr.length);
        for (int e: arr) {
            pq6.offer(e);
        }
        System.out.println("最小堆pq6中的尺寸为：" + pq6.size()); // 打印优先级队列中有效元素个数
        System.out.println("最小堆pq6中优先级最高的元素为：" + pq6.peek()); // 获取优先级最高的元素
        // 从优先级队列中删除两个元素之后，再次获取优先级最高的元素
        pq6.poll();
        System.out.println("删除pq6中的优先级最高的元素。");
        pq6.poll();
        System.out.println("删除pq6中的优先级最高的元素。");
        System.out.println("最小堆pq6中的尺寸为：" + pq6.size()); // 打印优先级队列中有效元素个数
        System.out.println("最小堆pq6中优先级最高的元素为：" + pq6.peek()); // 获取优先级最高的元素
        pq6.offer(0); // 插入元素0
        System.out.println("最小堆pq6中插入元素0。");
        System.out.println("最小堆pq6中优先级最高的元素为：" + pq6.peek()); // 获取优先级最高的元素
        // 将优先级队列中的有效元素删除掉，检测其是否为空
        pq6.clear();
        System.out.println("清空最小堆pq6。");
        if(pq6.isEmpty()){
            System.out.println("优先级队列pq6已经为空!!!");
        }
        else {
            System.out.println("优先级队列pq6不为空");
        }
    }

}

// 用户自己定义的比较器：直接实现Comparator接口，然后重写该接口中的compare方法即可
class IntCmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}