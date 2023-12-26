import java.util.Scanner;

public class WhoWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();
        System.out.printf("%s har vunnit", determineWinner(board));

    }
    public static String determineWinner(char[][] board) {
        // 8 options for winner
        // horizontal
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X'
                || board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X'
                || board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            return "Johan";
        } else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'
                || board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'
                || board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            return "Abdullah";
        }
        // vertical
        else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'
                || board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'
                || board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            return "Johan";
        } else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'
                || board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'
                || board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            return "Abdullah";
        }
        // diagonals
        else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' || board[0][2] == 'X'
                && board[1][1] == 'X' && board[2][0] == 'X') {
            return "Johan";
        } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O' || board[0][2] == 'O'
                && board[1][1] == 'O' && board[2][0] == 'O') {
            return "Abdullah";
        }

        return "ingen";
    }
}
