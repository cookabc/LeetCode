import java.util.Arrays;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.06
 */
public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {1};
        merge(nums2, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {0};
        merge(nums3, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums3));
    }
}
