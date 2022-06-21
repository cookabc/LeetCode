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
            int hCount = num / 100;
            if (hCount == 9) {
                sb.append("CM");
            } else if (hCount > 4) {
                sb.append("D");
                sb.append("C".repeat(hCount - 5));
            } else if (hCount == 4) {
                sb.append("CD");
            } else {
                sb.append("C".repeat(hCount));
            }
            num %= 100;
        }
        if (num >= 10) {
            int hCount = num / 10;
            if (hCount == 9) {
                sb.append("XC");
            } else if (hCount > 4) {
                sb.append("L");
                sb.append("X".repeat(hCount - 5));
            } else if (hCount == 4) {
                sb.append("XL");
            } else {
                sb.append("X".repeat(hCount));
            }
            num %= 10;
        }
        if (num >= 0) {
            if (num == 9) {
                sb.append("IX");
            } else if (num > 4) {
                sb.append("V");
                sb.append("I".repeat(num - 5));
            } else if (num == 4) {
                sb.append("IV");
            } else {
                sb.append("I".repeat(num));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
