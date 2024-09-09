package method;

/**
 * @Program: Java
 * @Package: method
 * @Class: HeapSort
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/09 13:48
 * @Version: 1.0
 */
public class HeapSort {
    //声明全局变量，用于记录数组array的长度；
    static int len;
    // 堆排序算法
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len == 0) return array;
        //1.构建一个大根堆
        buildMaxHeap(array);
        //2.循环将堆顶(最大值)与堆尾交换，删除堆尾元素，然后重新调整大根堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--; //原先的堆尾进入有序区，删除堆尾元素
            adjustHeap(array, 0); //重新调整大根堆
        }
        return array;
    }
    // 自顶向下调整以 i 为根的堆为大根堆
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (2 * i + 1 < len && array[2 * i + 1] > array[maxIndex])
            maxIndex = 2 * i + 1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (2 * i + 2 < len && array[2 * i + 2] > array[maxIndex])
            maxIndex = 2 * i + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
    // 自底向上构建初始大根堆
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始自底向上构造大根堆
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    // 交换数组内两个元素
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 8, 1, 2, 9, 4, 7, 6};

        HeapSort(a);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + ",");
        }
    }
}