import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.22
 */
public class Solution {

    private static final String[] NUMBER_TO_LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }

        List<String> result = new LinkedList<>();
        buildResult(result, new StringBuilder(), digits, 0);

        return result;
    }

    private static void buildResult(List<String> result, StringBuilder sb, String digits, int digitIdx) {
        // base case
        if (digitIdx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // recursive cases
        for (char c : NUMBER_TO_LETTERS[digits.charAt(digitIdx) - '0'].toCharArray()) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(c);
            buildResult(result, newSb, digits, digitIdx + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
