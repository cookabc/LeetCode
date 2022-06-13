import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.12
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        List<Character> resultList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            int checkIndex = resultList.indexOf(c);
            int resultLength = resultList.size();
            if (checkIndex != -1) {
                result = Math.max(result, resultLength);
                resultList = resultList.subList(checkIndex + 1, resultLength);
            }
            resultList.add(c);
        }
        result = Math.max(result, resultList.size());
        return result;
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
