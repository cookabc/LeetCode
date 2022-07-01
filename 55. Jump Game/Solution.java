/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.01
 */
public class Solution {

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean result = true;
        for (int i = 0; i < nums.length; i++) {
            if (!result) {
                return false;
            }
            if (nums[i] > 0) {
                continue;
            }
            result = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j > i || nums[j] + j == nums.length - 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 0, 1, 0}));
        System.out.println(canJump(new int[]{2, 0, 0}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 2, 2, 0, 4}));
    }
}
