import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.04
 */
public class Solution {

    public static void sortColors(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(3);
        countMap.put(0, 0);
        countMap.put(1, 0);
        countMap.put(2, 0);
        for (int num : nums) {
            countMap.put(num, countMap.get(num) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(0) > 0) {
                nums[i] = 0;
                countMap.put(0, countMap.get(0) - 1);
            } else if (countMap.get(1) > 0) {
                nums[i] = 1;
                countMap.put(1, countMap.get(1) - 1);
            } else {
                nums[i] = 2;
                countMap.put(2, countMap.get(2) - 1);
            }
        }
    }

    private static void printColors(int[] nums) {
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\n-----------");
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        printColors(nums);
        int[] nums2 = {2, 0, 1};
        printColors(nums2);
    }
}
