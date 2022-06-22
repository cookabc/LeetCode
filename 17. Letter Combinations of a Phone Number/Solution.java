import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.22
 */
public class Solution {

    private static final Map<Character, List<String>> DIGIT_MAP = Map.ofEntries(
            Map.entry('2', List.of("a", "b", "c")),
            Map.entry('3', List.of("d", "e", "f")),
            Map.entry('4', List.of("g", "h", "i")),
            Map.entry('5', List.of("j", "k", "l")),
            Map.entry('6', List.of("m", "n", "o")),
            Map.entry('7', List.of("p", "q", "r", "s")),
            Map.entry('8', List.of("t", "u", "v")),
            Map.entry('9', List.of("w", "x", "y", "z"))
    );

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        if (digits.length() == 1) {
            return DIGIT_MAP.get(digits.charAt(0));
        }
        List<String> result = new ArrayList<>();
        for (String item : DIGIT_MAP.get(digits.charAt(0))) {
            result.addAll(letterCombinations(digits.substring(1)).stream().map(letter -> item + letter).collect(Collectors.toList()));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
