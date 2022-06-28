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
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(count).append(prev.charAt(i));
        }
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
