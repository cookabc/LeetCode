/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.04
 */
public class Solution {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(101));
        System.out.println(mySqrt(121));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
