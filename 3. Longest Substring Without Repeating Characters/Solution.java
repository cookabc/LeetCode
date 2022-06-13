import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.12
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0;
        if (n < 2) {
            return n;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            char current = s.charAt(j);
            if (map.containsKey(current)) {
                i = Math.max(map.get(current), i);
            }
            res = Math.max(res, j - i + 1);
            map.put(current, j + 1);
        }
        return res;
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
