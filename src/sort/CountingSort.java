package sort;

/**
 * Created by zhanghe on 2016/7/10.
 * 计数排序
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        int max = max(A, 0, n);
        int min = min(A, 0, n);
        int length = max - min + 1;
        int[] B = new int[length];
        int[] C = new int[length];
        for(int i = 0; i < n; i++){
            B[A[i]-min] = A[i];
            C[A[i]-min] = C[A[i]-min] + 1;
        }
        for(int i = 0, j = 0; i < length; i++){
            while(C[i]-- > 0){
                A[j++] = B[i];
            }
        }
        return A;
    }
    private int max(int[] a,int i, int j){
        int max = a[i];
        for(; i < j; i++){
            if(max < a[i])
                max = a[i];
        }
        return max;
    }
    private int min(int[] a,int i, int j){
        int min = a[i];
        for(; i < j; i++){
            if(min > a[i])
                min = a[i];
        }
        return min;
    }
}
