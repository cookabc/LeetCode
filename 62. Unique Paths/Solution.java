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
        int count = 0;
        for (int i = 0; i < m; i++) {
            count += uniquePaths(m - i, n - 1);
        }
        return count;
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
