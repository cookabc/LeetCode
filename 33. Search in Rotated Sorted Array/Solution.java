import java.util.Arrays;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.26
 */
public class Solution {

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int mid = nums.length / 2;
        if (nums[mid] == target) {
            return mid;
        } else {
            if (nums[0] <= nums[mid - 1] && nums[0] <= target && target <= nums[mid - 1]) {
                return search(Arrays.copyOfRange(nums, 0, mid), target);
            }
            if (nums[0] > nums[mid - 1] && (nums[0] <= target || target <= nums[mid - 1])) {
                return search(Arrays.copyOfRange(nums, 0, mid), target);
            }
            if (nums[mid] <= nums[nums.length - 1] && nums[mid] <= target && target <= nums[nums.length - 1]) {
                int result = search(Arrays.copyOfRange(nums, mid, nums.length), target);
                return result == -1 ? -1 : result + mid;
            }
            if (nums[mid] > nums[nums.length - 1] && (nums[mid] <= target || target <= nums[nums.length - 1])) {
                int result = search(Arrays.copyOfRange(nums, mid, nums.length), target);
                return result == -1 ? -1 : result + mid;
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
