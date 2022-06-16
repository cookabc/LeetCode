import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.16
 */
public class Solution {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> ransomCharCountMap = getCharCountMap(ransomNote);
        Map<Character, Integer> magazineCharCountMap = getCharCountMap(magazine);
        for (char c : ransomCharCountMap.keySet()) {
            if (ransomCharCountMap.get(c) > magazineCharCountMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharCountMap(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aa", "aba"));
    }
}
