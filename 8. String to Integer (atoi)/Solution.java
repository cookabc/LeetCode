/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.20
 */
public class Solution {

    public static int myAtoi(String s) {
        boolean started = false;
        int negative = 1;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (!started) {
                if (c == ' ') {
                    continue;
                } else if (c == '+') {
                    started = true;
                } else if (c == '-') {
                    negative = -1;
                    started = true;
                } else if ((c >= 48 & c <= 57)) {
                    result = (c - 48) * negative;
                    started = true;
                } else {
                    break;
                }
            } else if (c >= 48 & c <= 57) {
                int pop = (c - 48) * negative;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + pop;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("+words and 987"));
        System.out.println(myAtoi("   -words and 987"));
    }
}
