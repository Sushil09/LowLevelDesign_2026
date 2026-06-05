package com.lld.systems.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        String first = "Sushil";
        String second = "Divyani";
        Game game = new Game(3,first,second);
        game.startGame();
    }
}

class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int moveCount;

    Scanner scanner = new Scanner(System.in);

    Game(int size, String player1Name, String player2Name) {
        this.board = new Board(size);
        player1 = new Player(player1Name,SYMBOL.O);
        player2 = new Player(player2Name,SYMBOL.X);
        this.currentPlayer = player1;
        moveCount = 0;
    }

    public void startGame() {
        while(true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " Where would you like to place?");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(!board.move(row,col,currentPlayer.getSymbol())) {
                System.out.println("Please enter valid position");
            }else {
                boolean winnerExists = board.checkWinner(row,col);
                moveCount++;
                if(winnerExists) {
                    System.out.println("The Winner is " + currentPlayer.getName());
                    System.out.println("Game Over");
                    break;
                }
                if(!winnerExists && moveCount == board.getSize() * board.getSize()) {
                    System.out.println("Game Draw");
                    break;
                }
                currentPlayer = currentPlayer == player1?player2:player1;
            }
        }
        board.printBoard();
    }

}

class Board {
    private char[][] board;
    @Getter
    private int size;

    Board(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
    }

    public boolean move(int row, int col, SYMBOL symbol) {
        if (row<size && col< size && row>=0 && col>=0 && board[row][col] == '.') {
            board[row][col] = symbol.getValue();
        } else {
            return false;
        }
        return true;
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
    }

    public boolean checkWinner(int row, int col) {
        if(rowWin(row,col) || colWin(row,col) || diagonalWin(row,col) || reverseDiagonalWin(row,col)) {
            return true;
        }
        return false;
    }

    private boolean rowWin(int row, int col) {
        for(int i=0;i<size;i++) {
            if(board[row][i]!=board[row][col])
                return false;
        }
        return true;
    }

    private boolean colWin(int row, int col) {
        for(int i=0;i<size;i++) {
            if(board[i][col]!=board[row][col])
                return false;
        }
        return true;
    }

    private boolean diagonalWin(int row, int col) {
        if (row != col) {
            return false;
        }
        char symbol = board[row][col];
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean reverseDiagonalWin(int row, int col) {
        if (row + col != size - 1) {
            return false;
        }

        char symbol = board[row][col];

        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbol) {
                return false;
            }
        }

        return true;
    }

    public void printBoard() {
        int size = board.length;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                System.out.print(" " + board[i][j] + " ");

                if (j < size - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("---");
                    if (k < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
class Player {
    private String name;
    private SYMBOL symbol;
}

enum SYMBOL {
    X('X'),
    O('O');

    private final char value;

    SYMBOL(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}



