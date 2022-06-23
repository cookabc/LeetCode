import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.23
 */
public class Solution {

    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            return List.of("()");
        }
        List<String> subParenthesis = generateParenthesis(n - 1);
        Set<String> resultSet = new HashSet<>();
        for (String s : subParenthesis) {
            resultSet.add("()" + s);
            resultSet.add(s + "()");
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    resultSet.add(s.substring(0, i + 1) + "()" + s.substring(i + 1));
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }
}
