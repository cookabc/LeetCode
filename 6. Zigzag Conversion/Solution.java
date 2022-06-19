import java.util.ArrayList;
import java.util.List;

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
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }
}
