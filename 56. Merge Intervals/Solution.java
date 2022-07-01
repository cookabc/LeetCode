import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.01
 */
public class Solution {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] < intervals[i][0]) {
                list.add(current);
                current = intervals[i];
            } else {
                current[0] = Math.min(current[0], intervals[i][0]);
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        list.add(current);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
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
