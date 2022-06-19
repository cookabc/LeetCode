import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.19
 */
public class Solution {

    /**
     * s       = PAYPALISHIRING
     * numRows = 3
     * result:
     * <p>
     * P___A___H___N
     * _A_P_L_S_I_I_G
     * __Y___I___R
     * </p>
     */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<List<Character>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
        }
        int roundLength = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i++) {
            if (i % roundLength == 0) {
                result.get(0).add(s.charAt(i));
            } else if (i % roundLength == roundLength / 2) {
                result.get(numRows - 1).add(s.charAt(i));
            } else {
                int index = i % roundLength;
                if (index > roundLength / 2) {
                    index = roundLength - index;
                }
                result.get(index).add(s.charAt(i));
            }
        }

        return result.stream().flatMap(List::stream).map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }
}
