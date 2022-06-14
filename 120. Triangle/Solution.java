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
        int firstElement = triangle.get(0).get(0);
        if (triangle.size() == 1) {
            return firstElement;
        }

        triangle = triangle.subList(1, triangle.size());

        List<List<Integer>> leftSubTriangle = triangle.stream()
                .map(rowList -> rowList.subList(0, rowList.size() - 1))
                .filter(rowList -> rowList.size() > 0)
                .collect(Collectors.toList());
        List<List<Integer>> rightSubTriangle = triangle.stream()
                .map(rowList -> rowList.subList(1, rowList.size()))
                .filter(rowList -> rowList.size() > 0)
                .collect(Collectors.toList());

        int leftSubValue = minimumTotal(leftSubTriangle);
        int rightSubValue = minimumTotal(rightSubTriangle);

        return firstElement + Math.min(leftSubValue, rightSubValue);
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(minimumTotal(List.of(List.of(-10))));
    }
}
