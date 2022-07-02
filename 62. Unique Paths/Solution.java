/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.02
 */
public class Solution {

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        m--;
        n--;
        // Swap, so that m is the bigger number
        if (m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long result = 1;
        int j = 1;
        // Instead of taking factorial, keep on multiply & divide
        for (int i = m + 1; i <= m + n; i++, j++) {
            result *= i;
            result /= j;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1));
        System.out.println(uniquePaths(2, 1));
        System.out.println(uniquePaths(1, 2));
        System.out.println(uniquePaths(2, 2));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePaths(3, 7));
    }
}
