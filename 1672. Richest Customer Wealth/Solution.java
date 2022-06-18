/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.18
 */
public class Solution {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int wealth = 0;
            for (int balance : account) {
                wealth += balance;
            }
            if (maxWealth < wealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{
                {1, 2, 3},
                {3, 2, 1}
        }));
        System.out.println(maximumWealth(new int[][]{
                {1, 5},
                {7, 3},
                {3, 5}
        }));
        System.out.println(maximumWealth(new int[][]{
                {2, 8, 7},
                {7, 1, 3},
                {1, 9, 5}
        }));
    }
}
