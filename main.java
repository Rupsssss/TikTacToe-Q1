//Tic Tac Toe:
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Lets play Tic Tac Toe ");
        System.out.println("what is your name? player 1: ");
        String p1 = scan.nextLine();
        System.out.println("what is your name? player 2: ");
        String p2 = scan.nextLine();

        //size of the board

        // 3x3 Tic Tac Toe board
        // - empty
        // x player 1
        // o player 2

        //the bracket means it's a 2d array
        char[][] board = new char [3][3];

        //fills the board with dashes
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
        //keep track of whose turn it is
        boolean isPlayer1 = true;

        //keep track if the game is over
        boolean gameEnded = false;

        while(!gameEnded) {
            //draw the board
            drawBoard(board);

            //keep track of what symbol we are using to play
            char symbol = ' ';
            if (isPlayer1){
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            //print out the player's turn
            if (isPlayer1){
                System.out.println(p1 + "'s turn (x): ");
            } else {
                System.out.println(p2 + "'s turn (o): ");
            }

            int row = 0;
            int column = 0;

            while(true) {
                //get rows and columns from user
                System.out.print("Enter a row (0, 1, or 2): ");
                row = scan.nextInt();
                System.out.print("Enter a column (0, 1, or 2): ");
                column = scan.nextInt();

                // checking if the row and columns are vaild
                if (row < 0 || column < 0 || row > 2 || column > 2){
                    //row and columns are out of bounds
                    System.out.println("Row and column are out of bound");
                } else if (board [row][column] != '-') {
                    //the spot is already taken
                    System.out.println("Someone has already made a move there");
                } else {
                    //row and columns are vaild
                    break;
                }
            }

            // setting the position on the board to the player's symbol
            board [row][column] = symbol;

            //check if a player has won
            if(hasWon(board) == 'x'){
                //player 1 has won
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if (hasWon(board) == 'o'){
                //player 2 has won
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {
                //nobody has won
                if (hasTied(board)) {
                    //tied
                    System.out.println("It's a tie");
                    gameEnded = true;
                }else {
                    //continue the game and toggles the trun
                    isPlayer1 = !isPlayer1;
                }
            }
        }

        //print out final state of the board
        drawBoard(board);
    }

    //printing out the board
    public static void drawBoard(char[][] board){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    //checking if someone has won
    public static char hasWon(char[][] board) {
        //row
        for (int i = 0; i <3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        //column
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }
        //diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board [2][0];
        }

        //nobody has won
        return '-';
    }

    //check if the board is full
    public static boolean hasTied(char[][] board){
        //check if there is a dash
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}