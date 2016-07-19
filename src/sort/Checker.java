package sort;

/**
 * Created by zhanghe on 2016/7/19.
 * 判断数组中是否有重复值。必须保证额外空间复杂度为O(1)
 * 若没有空间复杂度限制，采用哈希表实现。时间复杂度O(n),空间复杂度O(n)
 * 应采用非递归版本的堆排序，因为若使用递归，堆排序的空间复杂度为O(logn)
 */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        for(int i = n/2-1;i >= 0; i--){
            transforms(a, i, n-1);
        }
        for(int j = n-1; j > 0; j--){
            swap(a, 0, j);
            transforms(a, 0, j-1);
        }
        for(int i = 0; i < n-1; i++){
            if(a[i] == a[i+1])
               return true;
        }
        return false;
    }
    private void transforms(int[] a, int i, int n){
        while(2*i+1<=n){
            int j = 2*i+1;
            if(j < n && a[j] < a[j+1])
                j++;
            if(a[i] > a[j])
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
