// Eric Hom
// CS210 Project #2
// October 20, 2024

public class TicTacToeGame {
    private char[][] board;
    private int turns;

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char EMPTY = ' ';
    private static final char OUT_OF_BOUNDS = '@';

    /**
     * Creates a new tic-tac-toe game instance and initializes the
     * internal state of the game. After this method is called, the
     * newly created game board is filled with '_' (empty spaces) to
     * indicate that players have not yet occupied any spots.
     */
    public TicTacToeGame() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++ ) {
            for (int c = 0; c < 3; c++ ) {
                board[r][c] = EMPTY;
            }
        }
    }

    /**
     * Makes a move for the specified player, {@code p}, at location
     * ({@code r}, {@code c}) within the game board. If the move is invalid,
     * the method has no effect on the underlying board. The move is invalid
     * when the space is already occupied or the space is out of bounds.
     * Note: This method also increases the number of turns played if the move
     * is successful.
     *
     * @param p the character representing the player making the move.
     * @param r the row where the move is being made.
     * @param c the column where the move is being made.
     */
    public void playMove( char p, int r, int c ) {
    	board[r][c] = p; // places the char on the board that the user selects
    	
    	if (!isInBounds(r, c)) // error case if user places outside the board
    	{
    		return;
    	}
    	if (board[r][c] != EMPTY) // error case if place on board is already chosen 
    	{
    		return;
    	}
    	turns++;
    }

    /**
     * Returns whether the specified character, {@code p}, has
     * won the game.
     *
     * @return {@code true} if {@code p} has won the game and {@code false}
     * otherwise.
     * @param p the character to check.
     */
    public boolean isWinner( char p ) {
        // checking rows using a for loop 
        for (int r = 0; r < 3; r++) 
        {
            if (board[r][0] == p && board[r][1] == p && board[r][2] == p) // returns true if a row has all the same char
            {
                return true;
            }
        }

        // checking columns 
        for (int c = 0; c < 3; c++) 
        {
            if (board[0][c] == p && board[1][c] == p && board[2][c] == p) // returns true if a column has all the same char
            {
                return true;
            }
        }

        // checking diagonals
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) // returns true if diagonal left to right is all the same char
        {
            return true;
        }
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) // returns true if diagonal right to left is all the same char
        {
            return true;
        }

        return false; // No win found
    }

    /**
     * Returns whether the game board is full.
     *
     * @return {@code true} if the board is full and {@code false} otherwise.
     */
    public boolean isFull() {
        for (int i = 0; i < board.length; i++) // nested for loop to see if the board is full or empty, letting user place a char if it is still not full
        {
        	for (int j = 0; j < board.length; j++)
        	{
        		if (board[i][j] == EMPTY)
        		{
        			return false;
        		}
        	}
        }
        return true;
    }

    /**
     * Returns whether the game is a tie or not.
     * @return {@code true} if the game is a tie and {@code false} otherwise.
     */
    public boolean isTie() {
        if (isFull() == true && !isWinner(O) || !isWinner(X)) // returns true if the board is full or if there is no winner
        {
        	return true; 
        }
        return false;
    }


    /**
     * Returns whether the specified coordinates, {@code r} and {@code c} fall
     * within the boundaries of the game board.
     * @param r the row number to check.
     * @param c the column number to check.
     * @return {@code true} if the specified coordinates are in bounds and
     * {@code false} otherwise.
     */
    public boolean isInBounds( int r, int c ) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of turns taken so far in the game.
     * @return the number of turns taken so far.
     */
    public int numTurns() {
        return turns;
    }

    /**
     * Returns the player occupying the board location at the specified coordinates,
     * {@code r} and {@code c}.
     * @param r the row value to check.
     * @param c the column value to check.
     * @return the character representing the player located at position
     * ({@code r},{@code c} on the board. If the location is out of bounds, the method
     * returns the {@code @} character.
     */
    public char playerAt( int r, int c ) {
        if (isInBounds(r,c)) {
            return board[r][c];
        } else {
            return OUT_OF_BOUNDS;
        }
    }

    //Prints the contents of the game board.
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

}