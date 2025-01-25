import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char currentPlayer = 'X';
        byte numberOfSquaresPlayed = 0;
        boolean hasAWinner = false;

        while (numberOfSquaresPlayed < 9) {
            printBoard(board);
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            byte move = scanner.nextByte();
            if (move < 1 || move > 9) {
                System.out.println("Invalid move, please try again.");
                continue;
            }
            move--;
            if (board[move] == 'X' || board[move] == 'O') {
                System.out.println("That square is already taken, please try again.");
                continue;
            }
            board[move] = currentPlayer;
            // Check if the current player has won the game after the first player has played at lest 3 squares.
            if (numberOfSquaresPlayed >= 5 && hasWon(board, currentPlayer)) {
                hasAWinner = true;
                printBoard(board);
                System.out.println("Player " + currentPlayer + " has won!");
                break;
            }
            numberOfSquaresPlayed++;
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        if (!hasAWinner)
            System.out.println("Game over!, no player has won.");
    }

    private static void printBoard(char[] board) {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

    private static boolean hasWon(char[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
               (board[3] == player && board[4] == player && board[5] == player) ||
               (board[6] == player && board[7] == player && board[8] == player) ||
               (board[0] == player && board[3] == player && board[6] == player) ||
               (board[1] == player && board[4] == player && board[7] == player) ||
               (board[2] == player && board[5] == player && board[8] == player) ||
               (board[0] == player && board[4] == player && board[8] == player) ||
               (board[2] == player && board[4] == player && board[6] == player);
    }
}