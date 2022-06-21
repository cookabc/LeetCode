/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.21
 */
public class Solution {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int square;
            if (height[right] > height[left]) {
                square = height[left] * (right - left);
                left++;
            } else {
                square = height[right] * (right - left);
                right--;
            }
            if (square > result) {
                result = square;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }
}
