import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.09
 */
public class Solution {

    private static final Map<Character, Integer> ROMAN_MAP = Map.ofEntries(
            Map.entry('I', 1),
            Map.entry('V', 5),
            Map.entry('X', 10),
            Map.entry('L', 50),
            Map.entry('C', 100),
            Map.entry('D', 500),
            Map.entry('M', 1000)
    );

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int value = ROMAN_MAP.get(current);
            if (i < s.length() - 1) {
                char next = s.charAt(i + 1);
                if (needNegativeValue(current, next)) {
                    value = -value;
                }
            }
            result += value;
        }
        return result;
    }

    private static boolean needNegativeValue(char current, char next) {
        return current == 'I' && List.of('V', 'X').contains(next) ||
                current == 'X' && List.of('L', 'C').contains(next) ||
                current == 'C' && List.of('D', 'M').contains(next);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
