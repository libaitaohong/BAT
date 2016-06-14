package sort;

/**
 * Created by zhanghe on 2016/6/12.
 * 归并排序
 * merge函数是将两个分组归并，不管分组是否等长
 * param gap 每2个需要排序分组的数字总个数
 * param s 要归并的两组起始下标
 * param e 要归并的两组结束坐标
 * param  mid 要归并的两组中前一组最后一个下标
 */
public class MergeSort {
    public int[] mergeSort(int[] A, int n){
        for(int gap = 1; gap < n; gap = gap*2){
            for(int s = 0; s < n-gap; s += gap*2 ){
                int e = s + gap*2 - 1;
                int mid = s + gap - 1;
                if(e < n-1) //判断结束下标是否超出数组范围
                    merge(A, s, e, mid);
                else
                    merge(A, s, n-1, mid);
            }
        }
        return A;
    }
    private void merge(int[]A, int s, int e,int  mid){
        int[] aux = new int[e+1];
     //   System.arraycopy(A, s, aux, 0, e-s+1);
        for(int k = 0; k <= e; k++){
            aux[k] = A[k];
        }
        int i = s;
        int j = mid +1;
        for(int k = s; k <= e; k++){
            if(i > mid) //判断数组前一半是否已经排序完毕
                A[k] = aux[j++];
            else if(j > e) //判断数组后一半排序是否已经结束
                A[k] = aux[i++];
            else if(aux[i] < aux[j]) //如果前一半第一个比后一半第一个小
                A[k] = aux[i++]; //将该值放入数组A中
            else
                A[k] = aux[j++];
        }
    }
}
