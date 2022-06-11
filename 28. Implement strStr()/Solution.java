import java.util.Objects;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.11
 */
public class Solution {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0 || Objects.equals(haystack, needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }
}
