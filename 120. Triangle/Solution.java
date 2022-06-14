import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.14
 */
public class Solution {

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> reduceList = new ArrayList<>(Collections.nCopies(triangle.get(triangle.size() - 1).size(), 0));

        for (int j = triangle.size() - 1; j >= 0; j--) {
            List<Integer> rowList = triangle.get(j);
            if (rowList.size() == 1) {
                return rowList.get(0) + reduceList.get(0);
            }
            List<Integer> newRowList = new ArrayList<>();
            for (int i = 0; i < rowList.size() - 1; i++) {
                newRowList.add(Math.min(rowList.get(i) + reduceList.get(i), rowList.get(i + 1) + reduceList.get(i + 1)));
            }
            reduceList = newRowList;
        }

        return reduceList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(minimumTotal(List.of(List.of(-10))));
    }
}
