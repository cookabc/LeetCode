/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.26
 */
public class Solution {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curMax = nums[0];
        int allMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            allMax = Math.max(allMax, curMax);
        }
        return allMax;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
