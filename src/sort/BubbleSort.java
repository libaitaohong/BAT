package sort;
/**
 * Created by zhanghe on 2016/6/7
 * 冒泡排序
 */
/**
 * Created by zhanghe on 2016/6/7
 * 冒泡排序
 */
public class BubbleSort {
    public  int[] bubbleSort(int[] A, int n){
        int temp;
        if(A == null || n <2){
            return A;
        }
        for(int j = n; j > 1; j--){
            for (int i = 0; i < j - 1; i++) {
                if (A[i] > A[i + 1]) {
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
        return A;
    }
}
