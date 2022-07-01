import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.01
 */
public class Solution {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {4, 5}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {0, 4}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {2, 3}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {0, 0}
        })));
    }
}
