/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.07.05
 */
public class Solution {

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }
        return prev2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(45));
    }
}
