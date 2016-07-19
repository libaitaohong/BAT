package sort;

/**
 * Created by zhanghe on 2016/7/19.
 * 把两个有序的数组合并为一个数组，第一个数组空间正好可以容纳两个数组元素
 * 将两个数组的数从大到小比较，较大的数放在数组A的最后一个位置上
 * n m是两个数组的有效数大小
 * if else，当if不满足才执行else，满足则不执行else
 */
public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int l = m + n - 1;
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 || j >= 0){
            if (i < 0){
                A[l--] = B[j--];
            }else if (j < 0){
                A[l--] = A[i--];
            }else if(i >= 0 && j >=0){
                if(A[i] > B[j]) {
                    A[l--] = A[i--];
                } else{
                    A[l--] = B[j--];
                }
            }
        }
        return A;
    }
}
