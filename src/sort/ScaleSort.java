package sort;

/**
 * Created by zhanghe on 2016/7/12.
 * 小范围排序
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
 */
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        int[] B = new int[k];
        System.arraycopy(A, 0, B, 0, k);
        //先把前n-k位按照求小顶堆方法排序出来
        for(int i = k; i < n; i++){
            for(int j = k/2-1; j >= 0; j--){
                transform(B, j, k-1);
            }
            A[i-k] = B[0];
            B[0] = A[i];
        }
    //剩下的k-1位按照堆排序做
        for(int j = k-1; j >= 0; j--){
            transform(B, 0, j);
            swap(B, 0, j);
        }
        for(int i = 0; i < k; i++){
            A[n-1-i] = B[i];
        }

        return A;
    }
    private void transform(int[] a, int i, int k){
        while(2*i+1 <= k){
            int j = 2*i+1;
            if(j < k && a[j] > a[j+1])
                j++;
            if(a[i] < a[j])
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
