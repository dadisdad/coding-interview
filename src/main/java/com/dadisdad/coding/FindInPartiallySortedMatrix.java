package com.dadisdad.coding;

/**
 * 二维数组中的查找
 *
 * @author 10308
 * @date 2020/3/7
 */
public class FindInPartiallySortedMatrix {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean found = false;
        if (matrix.length != 0 && matrix != null) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (matrix[row][col] > target) {
                    // 如果右上角数大于目标数，则排除这一列
                    col--;
                } else if (matrix[row][col] < target) {
                    // 如果右上角数小于目标数，则排除这一行
                    row++;
                } else {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray(matrix, 7));
        System.out.println(findNumberIn2DArray(matrix, 20));
    }
}
