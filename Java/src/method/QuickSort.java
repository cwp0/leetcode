package method;

/**
 * @Program: Java
 * @Package: method
 * @Class: QuickSort
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/24 13:03
 * @Version: 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 8, 1, 2, 9, 4, 7, 6};

        quickSort(a, 0, a.length-1);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + ",");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int p = left;
        int q = right;
        int base = right; // 选取最右边的元素为基准元素
        while (p < q) {
            // 如果arr[p]小于arr[base]，则直接跳过
            // 找到大于arr[base]的arr[p]的p值
            while (p < q && arr[p] < arr[base]) {
                p++;
            }
            // 如果arr[q]大于arr[base]，也直接跳过
            // 找到小于arr[base]的arr[q]的q值
            while (p < q && arr[base] < arr[q]) {
                q--;
            }

            if (p < q) {
                // 交换p、q所在的元素的值
                swap(arr, p, q);
            }
        }

        swap(arr, p, base);
        quickSort(arr, left, p-1);
        quickSort(arr, p+1, right);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}