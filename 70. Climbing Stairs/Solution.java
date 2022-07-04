/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.05
 */
public class Solution {

    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
