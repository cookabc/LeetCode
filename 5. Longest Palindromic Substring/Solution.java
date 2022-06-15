/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.15
 */
public class Solution {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int len = s.length(); len > 1; len--) {
            for (int i = 0; i <= s.length() - len; i++) {
                String candidate = s.substring(i, len + i);
                if (isPalindrome(candidate)) {
                    return candidate;
                }
            }
        }
        return String.valueOf(s.charAt(0));
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
