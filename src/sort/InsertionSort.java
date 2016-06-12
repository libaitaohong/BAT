package sort;

/**
 * Created by zhanghe on 2016/6/12.
 * 使用for将数组元素向后挪
 * 插入排序
 */
public class InsertionSort {
    public int[] insertionSort(int[] A, int n){
        if(A == null && n < 0)
            return A;
        for(int i = 1; i < n; i++){
            int k = i;
            int temp;
            for(int j = i; j > 0; j--){ //比较的第i轮，将A[i]与他前面的数比较
                if(A[i] < A[j-1])
                    k = j-1; //将需插入的位置标记为k
            }
            if(k != i){
                temp = A[i];
                for(int s = i-k; s > 0 ; s--){ //将A[i]插入到A[k]位置上，k~i中间每个数往后挪一位
                    A[i] = A[i-1];
                    i--;
                }
                A[k] = temp;
            }
        }
        return A;
    }
}
