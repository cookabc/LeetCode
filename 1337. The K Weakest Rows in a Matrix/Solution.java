import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.17
 */
public class Solution {

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            indexMap.put(i, sum);
        }
        return indexMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
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
    }
}
