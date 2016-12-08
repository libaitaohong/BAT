package sort;

/**
 * Created by zhanghe on 2016/6/28.
 * 堆排序
 * (n-1)/2就是最后一个有孩子的父节点下标
 * 父节点为i，左孩子为2i+1，右孩子为2i+2
 */
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        //构造初始大顶堆
        //构造初始大顶堆，从最后一个非叶结点开始调整，较大的数放在父节点上，若交换了父子节点，需要将子节点也调整为大顶堆
        for(int i = n/2-1;i >= 0; i--){
            transform(A, i, n-1);
        }
        //排序开始，将根节点与最后一个叶子节点交换
        for(int j = n-1; j > 0; j--){
            swap(A, 0, j); //将根节点与最后一个节点交换
            transform(A, 0, j-1); //删掉最后一个节点，将新的堆构建为大顶堆
        }
        return A;
    }
    private void transform(int[] a, int i, int n){
        while(2*i+1 <= n){ //保证左孩子的下标值<=数组最后下标。小于表明有右孩子，等于表明有左孩子，没有右孩子
            int j = 2*i+1; //让j表示左孩子下标
            if(j < n && a[j] < a[j+1]) //如果j<n，表示有左孩子，也有右孩子。这里要判断父节点的两个孩子谁更大，如果j=n,没有右孩子，不用比较
                j++;            //如果右孩子比左孩子大，令j等于右孩子下标。
            if(a[i] > a[j]) //再比较大孩子与父节点谁大，父节点大不用交换，这里是大顶堆，回到外层函数中，继续下一个非叶结点构建大顶堆。
                break;
            swap(a, i, j); //父节点小于大孩子节点，交换两个节点值
            i = j; //继续while，交换后的以大孩子节点(原父节点)为父节点的堆构建大顶堆
        }
    }
    private static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
