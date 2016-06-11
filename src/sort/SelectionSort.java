package sort;

/**
 * Created by zhanghe on 2016/6/8.
 * 选择排序
 * 将第i小的数放在第i-1位置上
 */
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        if(A == null || n < 2)
            return A;
        int temp;
        for(int i = 0; i < n-1; i++){
            int k = i;
            for(int j = i; j < n-1; j++){
                if(A[k] > A[j+1])
                    k = j + 1;
            }
            temp = A[i];
            A[i] = A[k];
            A[k] = temp;
        }
        return A;
    }
}
