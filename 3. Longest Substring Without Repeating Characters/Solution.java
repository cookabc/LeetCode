/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.12
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        StringBuilder resultStr = new StringBuilder();
        int resultLength = resultStr.length();
        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);
            if (resultStr.toString().contains(current)) {
                resultStr = new StringBuilder(resultStr.substring(resultStr.indexOf(current) + 1));
            }
            resultStr.append(c);
            resultLength = Math.max(resultStr.length(), resultLength);
        }

        return resultLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
