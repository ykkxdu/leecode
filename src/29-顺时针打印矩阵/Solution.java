/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例：输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
* */
public class Solution {
    public static void main(String[]  args){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));

    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        // 数组的长
        int n = 0,d = matrix.length - 1;
        // 数组的宽
        int m = 0, r = matrix[0].length - 1;
        // 结果数组索引
        int idx = 0;
        while (true) {
            for (int i = m; i <= r; i++) {
                res[idx++] = matrix[n][i];
            }
            if (++n > d) {
                break;
            }
            for (int i = n; i <= d; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < m) {
                break;
            }
            for (int i = r; i >= m; i--) {
                res[idx++] = matrix[d][i];
            }
            if (--d < n) {
                break;
            }
            for (int i = d; i >= n; i--) {
                res[idx++] = matrix[i][m];
            }
            if (++m > r) {
                break;
            }
        }
        return res;

    }

    /**
     * 将矩阵看成若干层，从首先打印最外层匀速，其次打印次外层的元素，直到打印最内层的元素。
     * 对于每层，从左上方开始以顺时针的顺序遍历所有元素。假设当前层的左上角位于 (top,left)，右下角位于(bottom,right)，按照如下顺序遍历当前层的元素。
     *从左到右遍历上侧元素，依次为(top,left)到(top,right)。
     * 从上到下遍历右侧元素，依次为(top+1,right) 到 (bottom,right)。
     *如果left<right 且top<bottom，则从右到左遍历下侧元素，依次为(bottom,right−1)到(bottom,left+1)，
     * 以及从下到上遍历左侧元素，依次为(bottom,left)到(top+1,left)。
     *
     *
    * */
    public int[] spiralOrder_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}

