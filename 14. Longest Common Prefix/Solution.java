/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.09
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        String base = strs[0];
        for (int i = 0; i < base.length(); i++) {
            boolean appendable = true;
            for (String str : strs) {
                if (str.length() <= i || str.charAt(i) != base.charAt(i)) {
                    appendable = false;
                    break;
                }
            }
            if (appendable) {
                result.append(base.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
