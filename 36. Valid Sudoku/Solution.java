import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.27
 */
public class Solution {

    public static boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            Map<Character, Integer> checkMap = initCheckMap();
            for (int j = 0; j < board.length; j++) {
                if (chars[j] != '.') {
                    checkMap.put(chars[j], checkMap.get(chars[j]) + 1);
                }
            }
            if (checkMap.values().stream().anyMatch(i -> i > 1)) {
                return false;
            }
        }
        for (int j = 0; j < board.length; j++) {
            Map<Character, Integer> checkMap = initCheckMap();
            for (char[] chars : board) {
                if (chars[j] != '.') {
                    checkMap.put(chars[j], checkMap.get(chars[j]) + 1);
                }
            }
            if (checkMap.values().stream().anyMatch(v -> v > 1)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Map<Character, Integer> checkMap = initCheckMap();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i * 3 + k][j * 3 + l] != '.') {
                            checkMap.put(board[i * 3 + k][j * 3 + l], checkMap.get(board[i * 3 + k][j * 3 + l]) + 1);
                        }
                    }
                }
                if (checkMap.values().stream().anyMatch(v -> v > 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<Character, Integer> initCheckMap() {
        Map<Character, Integer> checkMap = new HashMap<>(10);
        for (int i = 48; i < 58; i++) {
            checkMap.put((char) i, 0);
        }
        return checkMap;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '5', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }
}
