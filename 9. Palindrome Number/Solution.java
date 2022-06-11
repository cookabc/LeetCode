/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.11
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int newNum = 0;
        while (x > newNum) {
            newNum = newNum * 10 + x % 10;
            x = x / 10;
        }
        return x == newNum || x == newNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
