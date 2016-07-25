package sort;

/**
 * Created by zhanghe on 2016/7/25.
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 数组左边设置0区域， 右边设置2区域。0放到0区域中，2放到2区域中
 */
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        int i = 0;
        int j = n-1;
        for(int k = 0; k <= j; k++){
            if (A[k] == 0){
                swap(A, k, i);
                i++;
            }else if (A[k] == 2){
                swap(A, k, j);
                j--;
                k--;
            }
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
