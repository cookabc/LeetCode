/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.24
 */
public class Solution {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        int result = 0;
        int sign = dividend > 0 == divisor > 0 ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend == divisor) {
            return sign;
        }

        for (int i = 0, val = divisor; dividend - divisor >= 0; i = 0, val = divisor) {
            while (val > 0 && dividend - val >= 0) {
                val = divisor << ++i;
            }
            dividend -= divisor << i - 1;
            result += 1 << i - 1;
        }
        return sign < 0 ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 2));
        System.out.println(divide(2, 2));
        System.out.println(divide(-2, 2));
        System.out.println(divide(7, -3));
        System.out.println(divide(1, 3));
        System.out.println(divide(10, 3));
        System.out.println(divide(Integer.MIN_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(Integer.MAX_VALUE, -1));
    }
}
