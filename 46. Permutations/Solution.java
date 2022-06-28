import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.28
 */
public class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return List.of(List.of(nums[0]));
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> pre = permute(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> integers : pre) {
            for (int j = 0; j <= integers.size(); j++) {
                List<Integer> temp = new ArrayList<>(integers);
                temp.add(j, nums[0]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1}));
        System.out.println(permute(new int[]{0, 1}));
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
