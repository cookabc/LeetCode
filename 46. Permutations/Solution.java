import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.28
 */
public class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private static void permute(int[] nums, List<List<Integer>> result, List<Integer> iterList, boolean[] used) {
        if (iterList.size() == nums.length) {
            result.add(new ArrayList<>(iterList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            iterList.add(nums[i]);
            used[i] = true;
            permute(nums, result, iterList, used);
            used[i] = false;
            iterList.remove(iterList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1}));
        System.out.println(permute(new int[]{0, 1}));
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
