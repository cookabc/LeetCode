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
        char[][] result = new char[numRows][s.length()];
        int maxRowIndex = numRows - 1;
        int roundLength = maxRowIndex * 2;
        int direction = 1;
        int rowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int round = i / roundLength;
            if (direction == 1) {
                result[rowIndex][round * 2] = s.charAt(i);
                rowIndex++;
            } else {
                result[rowIndex][round * 2 + 1] = s.charAt(i);
                rowIndex--;
            }
            if (rowIndex == 0 || rowIndex == maxRowIndex) {
                direction = -direction;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] chars : result) {
            for (char aChar : chars) {
                if (Character.isLetter(aChar) || aChar == '.' || aChar == ',') {
                    sb.append(aChar);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }
}
