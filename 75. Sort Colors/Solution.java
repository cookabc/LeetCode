/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.04
 */
public class Solution {

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
