/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.24
 */
public class Solution {

    public static int divide(int dividend, int divisor) {
        // Check for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // Sign of result
        int sign = dividend > 0 == divisor > 0 ? 1 : -1;
        // Quotient
        int quotient = 0;
        // Take the absolute value
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);
        // Loop until the divisor is greater than dividend
        while (absoluteDividend >= absoluteDivisor) {
            // This represents the number of bits shifted or
            // how many times we can double the number
            int shift = 0;
            while (absoluteDividend >= (absoluteDivisor << shift)) {
                shift++;
            }
            // Add the number of times we shifted to the quotient
            quotient += (1 << (shift - 1));
            // Update the dividend for the next iteration
            absoluteDividend -= absoluteDivisor << (shift - 1);
        }
        return sign == -1 ? -quotient : quotient;
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
