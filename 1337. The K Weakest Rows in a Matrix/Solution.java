import java.util.Arrays;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.17
 */
public class Solution {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int y = mat.length, x = mat[0].length, idx = 0;
        int[] row = new int[y], result = new int[k];
        for (int j = 0; j <= x; j++) {
            for (int i = 0; i < y; i++) {
                if (row[i] == 0 && (j == x || mat[i][j] == 0)) {
                    result[idx++] = i;
                    row[i]++;
                }
                if (idx == k) {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(kWeakestRows(a1, 3)));
        int[][] a2 = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        System.out.println(Arrays.toString(kWeakestRows(a2, 2)));
        int[][] a3 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(kWeakestRows(a3, 1)));
        int[][] a4 = {
                {1, 0},
                {1, 0},
                {1, 0},
                {1, 1}
        };
        System.out.println(Arrays.toString(kWeakestRows(a4, 4)));
    }
}
