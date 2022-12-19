import java.util.*;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.10
 */
public class Solution {

    public static boolean isValid(String s) {
        List<Character> openList = List.of('(', '[', '{');
        List<Character> closeList = List.of(')', ']', '}');
        Map<Character, Character> bracketMap = Map.ofEntries(
                Map.entry('(', ')'),
                Map.entry('[', ']'),
                Map.entry('{', '}')
        );

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (openList.contains(c)) {
                stack.push(c);
            }
            if (closeList.contains(c)) {
                if (stack.isEmpty() || !Objects.equals(c, bracketMap.get(stack.pop()))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("["));
        System.out.println(isValid("]"));
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
    }
}
