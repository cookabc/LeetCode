/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.29
 */
public class Solution {

    public static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int top = 0, bottom = rows - 1; top < bottom; top++, bottom--) {
            int[] tmp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = tmp;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private static void rotateAndLog(int[][] matrix) {
        System.out.println("---------------");
        rotate(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.printf("%-3s", i);
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        rotateAndLog(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        rotateAndLog(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }
}
