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

        int originalNum = x;
        int newNum = 0;
        while (x != 0) {
            int reminder = x % 10;
            newNum = newNum * 10 + reminder;
            x = x / 10;
        }
        return originalNum == newNum;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
