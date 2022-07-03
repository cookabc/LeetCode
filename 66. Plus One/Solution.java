import java.util.Arrays;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.03
 */
public class Solution {

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int extra = 1;
        while (extra == 1 && i >= 0) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
                if (i == 0) {
                    break;
                }
                i--;
            } else {
                digits[i]++;
                extra = 0;
            }
        }
        if (extra == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
    }
}
