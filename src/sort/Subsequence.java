package sort;

/**
 * Created by zhanghe on 2016/7/25.
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
 * (原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * 最优解：时间复杂度O(n),空间复杂度O(1)
 * 从左向右遍历数组，记录：遍历过的最大值，最大值大于当前数的情况最右位置，
 * 从右向左遍历，记录：最小值，最小值小于当前数的最左位置
 * 左右两边值相减加一为最终结果
 
 其实就是从左向右遍历一遍，当前值大于max，就令max等于它，当前值小于max，就令r等于当前值下标。
意思就是从左向右遍历一遍，令max为当前遍历过最大的，若最大值右边还有比它小的，说明它是需要排序的，记录这个值为r
同理，从右向左遍历一遍，令min为当前遍历过的值中最小的，若它左边还有比最小值大的，说明需要排序，记录这个值为l
 */
public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        int l = 0, r = 0;
        int max = A[0];
        int min = A[n-1];
        for (int i = 1; i < n; i++){
            if (A[i] > max){
                max = A[i];
            }else if(A[i] < max){
                r = i;
            }
        }
        for (int i = n-2; i >=0; i--){
            if(A[i] > min){
                l = i;
            }else if (A[i] < min){
                min = A[i];
            }
        }
        if (r == l){
            return 0;
        }else{
            return r-l+1;
        }
    }
}
