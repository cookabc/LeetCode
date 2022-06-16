import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.16
 */
public class Solution {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alphabet[magazine.charAt(i) - 'a'] += 1;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            alphabet[ransomNote.charAt(j) - 'a'] -= 1;
            if (alphabet[ransomNote.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aa", "aba"));
    }
}
