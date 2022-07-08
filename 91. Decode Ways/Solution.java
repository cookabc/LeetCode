/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.08
 */
public class Solution {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = chars[0] == '0' ? 0 : 1;
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            char prev = chars[i - 1];
            if (current >= '1' && current <= '9') {
                dp[i] = dp[i - 1];
            }
            if ((prev == '1' && current >= '0' && current <= '9') ||
                    (prev == '2' && current >= '0' && current <= '6')) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[chars.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("127"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("06"));
        System.out.println(numDecodings("60"));
        System.out.println(numDecodings("1601"));
        System.out.println(numDecodings("11106"));
    }
}
