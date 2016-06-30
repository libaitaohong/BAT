package sort;

/**
 * Created by zhanghe on 2016/6/28.
 * 堆排序
 * (n-1)/2就是最后一个有孩子的父节点下标
 */
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        //构造初始大顶堆
        for(int i = n/2-1;i >= 0; i--){
            transform(A, i, n-1);
        }
        //排序开始，将根节点与最后一个叶子节点交换
        for(int j = n-1; j > 0; j--){
            swap(A, 0, j);
            transform(A, 0, j-1);
        }
        return A;
    }
    private void transform(int[] a, int i, int n){
        while(2*i+1 <= n){
            int j = 2*i+1;
            if(j < n && a[j] < a[j+1])
                j++;
            if(a[i] > a[j])
                break;
            swap(a, i, j);
            i = j;

        }
    }
    private static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
