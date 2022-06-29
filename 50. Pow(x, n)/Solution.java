/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.30
 */
public class Solution {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(1, 2));
        System.out.println(myPow(1, 0));
        System.out.println(myPow(0, 2));
        System.out.println(myPow(-1, 3));
    }
}
