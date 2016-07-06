package sort;

/**
 * Created by zhanghe on 2016/7/6.
 * 希尔排序
 *
 */
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        int N = A.length;
        int h = 1;
        while(h < N/3) //设置步长
            h = h*3+1;
        while(h >=1){ //循环排序
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && A[j] < A[j-h]; j -= h)
                    swap(A, j, j-h);
            }
            h = h/3;
        }
        return A;
    }
    private static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
