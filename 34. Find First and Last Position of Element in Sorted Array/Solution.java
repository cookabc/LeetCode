import java.util.Arrays;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.27
 */
public class Solution {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length;
        boolean find = false;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                find = true;
                break;
            }
        }
        return find ? new int[]{left, right} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11)));
    }
}
