/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.26
 */
public class Solution {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5}, 0));
        System.out.println(search(new int[]{1, 3, 5}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{1, 2, 4, 5, 6, 7, 0}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1, 2}, 1));
        System.out.println(search(new int[]{2, 1}, 1));
        System.out.println(search(new int[]{1}, 0));
    }
}
