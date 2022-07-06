import java.util.Arrays;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.06
 */
public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            if (i >= m) {
                temp[k] = nums2[j];
                j++;
            } else if (j >= n) {
                temp[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        System.arraycopy(temp, 0, nums1, 0, temp.length);
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
        int[] nums4 = {2, 0};
        merge(nums4, 1, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums4));
    }
}
