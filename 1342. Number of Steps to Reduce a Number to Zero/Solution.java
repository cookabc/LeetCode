/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.18
 */
public class Solution {

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }
}
