import java.util.Arrays;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.07.03
 */
public class Solution {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
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
