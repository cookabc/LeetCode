import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.08
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int candidate = target - nums[i];
            if (numsMap.containsKey(candidate)) {
                return new int[]{i, numsMap.get(candidate)};
            }
            numsMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
