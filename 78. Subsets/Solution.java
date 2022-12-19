import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.07.05
 */
public class Solution {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(num);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{0}));
        System.out.println(subsets(new int[]{1, 2}));
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }
}
