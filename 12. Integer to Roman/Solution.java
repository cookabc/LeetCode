/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.21
 */
public class Solution {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            sb.append("M".repeat(num / 1000));
            num %= 1000;
        }
        if (num >= 100) {
            append(sb, "C", "M", "D",  num / 100);
            num %= 100;
        }
        if (num >= 10) {
            append(sb, "X", "C", "L",  num / 10);
            num %= 10;
        }
        if (num >= 0) {
            append(sb, "I", "X", "V", num);
        }
        return sb.toString();
    }

    private static void append(StringBuilder sb, String base, String upper, String lower, int count) {
        if (count == 9) {
            sb.append(base).append(upper);
        } else if (count > 4) {
            sb.append(lower);
            sb.append(base.repeat(count - 5));
        } else if (count == 4) {
            sb.append(base).append(lower);
        } else {
            sb.append(base.repeat(count));
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
