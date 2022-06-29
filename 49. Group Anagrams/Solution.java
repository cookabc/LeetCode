import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String s : strs) {
            char[] count = new char[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            String key = new String(count);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new LinkedList<>());
            }
            resultMap.get(key).add(s);
        }
        return new LinkedList<>(resultMap.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
