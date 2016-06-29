package sort;

/**
 * Created by zhanghe on 2016/6/28.
 * 堆排序
 * param h 堆深度，深度计算公式min(log2n)+1
 * param l 最后一个父节点，数组下标为l-1
 * 父亲为i，左孩子为2(i+1)-1，即2*i+1,右孩子为2(i+1)，即2*i+2
 * (n-1)/2就是最后一个有孩子的父节点下标
 */
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        //求堆深度
       // int h = (int)Math.floor(log(n,2))+1;
        //找到最后一个父节点
       // int l = (int)Math.pow(2,h-1)-1;
        //构造初始大顶堆
        for(int i = (n-1)/2;i >= 0; i--){
            transform(A, i, n-1);
        }
        for(int i = 1; i <= (n-1)/2; i++){
            transform(A, i, n-1);
        }
        //排序开始，将根节点与最后一个叶子节点交换
        for(int j = n-1; j > 0; j--){
            swap(A, 0, j);
            for(int i = 0; i < (n-1)/2; i++){
                transform(A, i, j-1);
            }
        }
        return A;
    }
    private void transform(int[] a, int i, int n){
        if(2*i+2 <= n){
            if(a[2*i+1] > a[2*i+2]){
                if(a[2*i+1] > a[i])
                    swap(a, i, 2*i+1);
            }else{
                if(a[2*i+2] > a[i])
                    swap(a, i, 2*i+2);
            }
        }else if(2*i+1 == n){
            if(a[2*i+1] > a[i])
                swap(a, i, 2*i+1);
        }
    }
    private static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //换底公式，计算log2
    private static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}
