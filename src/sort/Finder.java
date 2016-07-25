package sort;

/**
 * Created by zhanghe on 2016/7/25.
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，
 * 代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 * 思路：从矩阵的右上角开始查找。有序矩阵，每一行从左到右逐渐增大，每一列从上到下逐渐增大
 * 若x比当前位置数小，则x不可能在该列；若x比当前数大，则x不可能在当前行。
 * 就是控制当前位置是向下还是向左移动，直到找到x。没有x则返回false
 */
public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        for (int row = 0,column = m-1; row < n && column >= 0;) {
            if (mat[row][column] > x){
                column--;
            }else if(mat[row][column] < x){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}
