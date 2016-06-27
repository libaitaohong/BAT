package sort;

/**
 * Created by zhanghe on 2016/6/27.
 * 快排
 * param a 每组排序树的最后一个，划分值
 * param l 最小区间长度+s
 * 要注意每一个划分值其实已经处在正确位置，在递归时将它去掉
 */
public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        sort(A, 0, n - 1);
        return A;
    }
    private void sort(int[] A, int s, int e){
        int a = A[e];
        int l = s;
        for(int i = s; i < e; i++){
            if(A[i] < a){
                swap(A, i, l);
                l++;
            }
            if(i == e - 1){
                swap(A, l, e);
            }
        }
        judge(A, s, l-1);
        judge(A, l+1, e);
    }
    private void judge(int[] a, int s, int e){
        if(e - s >= 1)
            sort(a, s, e);
    }
    private static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
