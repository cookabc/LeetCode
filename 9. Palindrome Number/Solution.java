import java.util.Arrays;
import java.util.Objects;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.11
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return Objects.equals(new StringBuilder(Integer.toString(x)).reverse().toString(), Integer.toString(x));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
