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
        if (x < 4) {
            return 1;
        }
        long s = x / 2;
        while (s * s > x) {
            s /= 2;
        }
        while (s * s <= x) {
            s += 1;
        }
        return (int) s - 1;
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
