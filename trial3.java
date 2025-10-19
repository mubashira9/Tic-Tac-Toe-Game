// Author: Mubashira Shaik

import java.util.Scanner;

public class trial3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display welcome message and instructions
        System.out.println("========================================");
        System.out.println("          WELCOME TO TIC TAC TOE");
        System.out.println("========================================");
        System.out.println("\nGAME INSTRUCTIONS:");
        System.out.println("1. The board is a 3x3 grid with positions from (0,0) to (2,2)");
        System.out.println("2. Player 1 uses 'X' and Player 2 uses 'O'");
        System.out.println("3. Players alternate turns");
        System.out.println("4. To place a symbol, enter row and column (0-2) separated by a space");
        System.out.println("   Example: '0 1' places your symbol at row 0, column 1");
        System.out.println("5. First player to get 3 in a row wins");
        System.out.println("6. If all cells are filled with no winner, the game is a draw");
        System.out.println("========================================\n");

        boolean continueGame = true; // Controls if players want to play again

        while (continueGame) {
            // Initialize an empty 3x3 board
            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }

            char currentPlayer = 'X'; // Player 1 starts first
            boolean gameActive = true; // Controls if the current round is still active

            // Display the initial empty board
            System.out.println("Current Board:");
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            // Game loop for a single round
            while (gameActive) {
                boolean movePlaced = false; // Flag to ensure valid move is placed

                // Keep asking for move until valid input is given
                while (!movePlaced) {
                    int playerNum = (currentPlayer == 'X') ? 1 : 2;
                    System.out.print("Player " + playerNum + " (" + currentPlayer + "), enter your move (row column): ");

                    try {
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();

                        // Check if move is within valid range
                        if (row < 0 || row > 2 || col < 0 || col > 2) {
                            System.out.println("Invalid move! Row and column must be between 0 and 2.");
                        }
                        // Check if cell is already taken
                        else if (board[row][col] != '-') {
                            System.out.println("Invalid move! This cell is already occupied.");
                        }
                        // Valid move — place symbol
                        else {
                            board[row][col] = currentPlayer;
                            movePlaced = true;
                        }
                    } catch (Exception e) {
                        scanner.nextLine(); // Clear invalid input
                        System.out.println("Invalid input! Please enter two numbers between 0 and 2.");
                    }
                }

                // Display updated board
                System.out.println("Current Board:");
                System.out.println("  0 1 2");
                for (int i = 0; i < 3; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                // Check if the current player has won
                boolean playerWon = false;

                // Check rows
                for (int i = 0; i < 3 && !playerWon; i++) {
                    if (board[i][0] == currentPlayer &&
                        board[i][1] == currentPlayer &&
                        board[i][2] == currentPlayer) {
                        playerWon = true;
                    }
                }

                // Check columns
                for (int j = 0; j < 3 && !playerWon; j++) {
                    if (board[0][j] == currentPlayer &&
                        board[1][j] == currentPlayer &&
                        board[2][j] == currentPlayer) {
                        playerWon = true;
                    }
                }

                // Check diagonals
                if (!playerWon && board[0][0] == currentPlayer &&
                    board[1][1] == currentPlayer &&
                    board[2][2] == currentPlayer) {
                    playerWon = true;
                }

                if (!playerWon && board[0][2] == currentPlayer &&
                    board[1][1] == currentPlayer &&
                    board[2][0] == currentPlayer) {
                    playerWon = true;
                }

                // Check if all cells are filled (for draw)
                boolean boardFull = true;
                for (int i = 0; i < 3 && boardFull; i++) {
                    for (int j = 0; j < 3 && boardFull; j++) {
                        if (board[i][j] == '-') {
                            boardFull = false;
                        }
                    }
                }

                // Determine game outcome
                if (playerWon) {
                    int playerNum = (currentPlayer == 'X') ? 1 : 2;
                    System.out.println("Player " + playerNum + " WINS!");
                    gameActive = false;
                } else if (boardFull) {
                    System.out.println("It's a DRAW! The board is completely filled.");
                    gameActive = false;
                } else {
                    // Switch player for next turn
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            // Ask players if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            continueGame = response.equals("yes") || response.equals("y");
        }

        // Game ends
        System.out.println("Thanks for playing Tic Tac Toe!");
        scanner.close();
    }
}

/*

        EXAMPLE GAME SESSION:
        ========================================
                WELCOME TO TIC TAC TOE
        ========================================

        GAME INSTRUCTIONS:
        1. The board is a 3x3 grid with positions from (0,0) to (2,2)
        2. Player 1 uses 'X' and Player 2 uses 'O'
        3. Players alternate turns
        4. To place a symbol, enter row and column (0-2) separated by a space
        Example: '0 1' places your symbol at row 0, column 1
        5. First player to get 3 in a row wins
        6. If all cells are filled with no winner, the game is a draw
        ========================================

        Current Board:
        0 1 2
        0 - - - 
        1 - - - 
        2 - - - 

        Player 1 (X), enter your move (row column): 0 0 
        Current Board:
        0 1 2
        0 X - - 
        1 - - - 
        2 - - - 

        Player 2 (O), enter your move (row column): 1 0
        Current Board:
        0 1 2
        0 X - - 
        1 O - - 
        2 - - - 

        Player 1 (X), enter your move (row column): 1 1
        Current Board:
        0 1 2
        0 X - - 
        1 O X - 
        2 - - - 

        Player 2 (O), enter your move (row column): 0 2
        Current Board:
        0 1 2
        0 X - O 
        1 O X - 
        2 - - - 

        Player 1 (X), enter your move (row column): 2 2
        Current Board:
        0 1 2
        0 X - O 
        1 O X - 
        2 - - X 

        Player 1 WINS!
        Do you want to play again? (yes/no): no
        Thanks for playing Tic Tac Toe!
 */