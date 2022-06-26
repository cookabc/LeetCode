import java.util.Arrays;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.27
 */
public class Solution {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start, end;
        int mid = nums.length / 2;
        if (nums[mid] > target) {
            return searchRange(Arrays.copyOfRange(nums, 0, mid), target);
        } else if (nums[mid] < target) {
            int[] range = searchRange(Arrays.copyOfRange(nums, mid + 1, nums.length), target);
            if (range[0] == -1) {
                return new int[]{-1, -1};
            } else {
                return new int[]{mid + range[0] + 1, mid + range[1] + 1};
            }
        } else {
            start = mid;
            end = mid;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3}, 3)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
//        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }
}
