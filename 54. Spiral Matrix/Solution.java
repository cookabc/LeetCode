import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.30
 */
public class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }
}
