/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.28
 */
public class Solution {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder result = new StringBuilder();
        String prev = countAndSay(n - 1);
        int count = 1;
        int i = 0;
        while (i + 1 < prev.length()) {
            if (prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(prev.charAt(i));
                count = 1;
            }
            i++;
        }
        result.append(count).append(prev.charAt(i));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
