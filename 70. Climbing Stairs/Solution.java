/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.05
 */
public class Solution {

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] stepsArray = new int[n + 1];
        stepsArray[1] = 1;
        stepsArray[2] = 2;
        for (int i = 3; i <= n; i++) {
            stepsArray[i] = stepsArray[i - 1] + stepsArray[i - 2];
        }
        return stepsArray[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(45));
    }
}
