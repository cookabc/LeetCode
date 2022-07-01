/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.01
 */
public class Solution {

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 0, 1, 0}));
        System.out.println(canJump(new int[]{2, 0, 0}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 2, 2, 0, 4}));
    }
}
