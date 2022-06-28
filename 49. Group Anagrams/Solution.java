import java.util.*;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.29
 */
public class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs));
        }
        Map<String, ArrayList<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (resultMap.containsKey(key)) {
                resultMap.get(key).add(str);
            } else {
                resultMap.put(key, new ArrayList<>(List.of(str)));
            }
        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
