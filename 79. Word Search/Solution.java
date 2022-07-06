import java.util.stream.IntStream;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.07.06
 */
public class Solution {

    public static boolean exist(char[][] board, String word) {
        return IntStream.range(0, board.length)
                .anyMatch(
                        i -> IntStream.range(0, board[0].length).anyMatch(
                                j -> (board[i][j] == word.charAt(0)) && exist(board, word, i, j, 0)
                        )
                );
    }

    private static boolean exist(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = exist(board, word, i + 1, j, k + 1)
                || exist(board, word, i - 1, j, k + 1)
                || exist(board, word, i, j + 1, k + 1)
                || exist(board, word, i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }
}
