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
        Map<Character, Integer> magazineCharCountMap = getCharCountMap(magazine);
        for (char c : ransomNote.toCharArray()) {
            if (magazineCharCountMap.getOrDefault(c, 0) == 0) {
                return false;
            }
            magazineCharCountMap.put(c, magazineCharCountMap.get(c) - 1);
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
