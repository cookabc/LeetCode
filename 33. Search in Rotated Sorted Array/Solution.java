/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.26
 */
public class Solution {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
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
