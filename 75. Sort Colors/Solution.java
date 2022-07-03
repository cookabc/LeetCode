/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.04
 */
public class Solution {

    public static void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
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
