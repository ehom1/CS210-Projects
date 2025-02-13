import java.util.Scanner;

public class TicTacToeDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        char p = 'X';
        TicTacToeGame game = new TicTacToeGame();
        int r, c;

        // the main game loop
        while (!(game.isWinner('X') || game.isWinner('O') || game.isFull())) {
            game.displayBoard();
            System.out.print("'" + p + "', enter your location separated by a space (row column): ");
            r = keyboard.nextInt();
            c = keyboard.nextInt();

            while (game.isInBounds(r, c) == false || game.playerAt(r, c) != ' ') {
                if (game.isInBounds(r, c) == false) {
                    System.out.println("That is not a valid location. Try again.");
                } else if (game.playerAt(r, c) != ' ') {
                    System.out.println("That location is already full. Try again.");
                }
                System.out.print("Choose your location (row, column): ");
                r = keyboard.nextInt();
                c = keyboard.nextInt();
            }
            game.playMove(p, r, c);
            p = (p == 'X') ? 'O' : 'X';
        }

        game.displayBoard();
        if (game.isWinner('O')) {
            System.out.println("O is the winner!");
        }
        if (game.isWinner('X')) {
            System.out.println("X is the winner!");
        }
        if (game.isTie()) {
            System.out.println("It is a tie.");
        }
    }
}