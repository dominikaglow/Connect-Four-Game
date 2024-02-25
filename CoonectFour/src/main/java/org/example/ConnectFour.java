package org.example;

import java.util.*;

public class ConnectFour {
    static int[][] board = new int[6][7]; //1 - red, 2 - yellow

    public static void clearArray(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0; // lub inną wartość domyślną
            }
        }
    }

    public static void findSpot(int col, int player) {
        for(int i = board.length - 1; i >= 0; i--) {
            if(board[i][col] == 0) {
                board[i][col] = player;
                break;
            }
        }
    }

    public static int isWinner() {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]
                        && board[i][j] != 0) {
                    return board[i][j];
                }
            }
        }

        for(int j = 0; j < board[0].length; j++){
            for(int k = 0; k < 3; k++) {
                if(board[k][j] == board[k+1][j] && board[k][j] == board[k+2][j] && board[k][j] == board[k+3][j]
                        && board[k][j] != 0) {
                    return board[k][j];
                }
            }
        }

        for(int k = 0; k < board.length - 3; k++) {
            for(int j = 0; j < board[0].length - 3; j++) {
                if(board[k][j] == board[k+1][j+1] && board[k][j] == board[k+2][j+2] && board[k][j] == board[k+3][j+3]
                        && board[k][j] > 0) {
                    return board[k][j];
                }
            }
        }

        for(int k = 0; k < board.length - 3; k++) {
            for(int j = 3; j < board[0].length; j++) {
                if(board[k][j] == board[k+1][j-1] && board[k][j] == board[k+2][j-2] && board[k][j] == board[k+3][j-3]
                        && board[k][j] > 0) {
                    return board[k][j];
                }
            }
        }
        return -1;
    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        int winner = -1;
        for(String move : piecesPositionList) {

            String[] playersMove = move.split("_");
            String col = playersMove[0];
            String player = playersMove[1];
            int idOfPlayer = player.equals("Red") ? 1 : 2;

            switch(col) {
                case "A":
                    findSpot(0, idOfPlayer);
                    break;
                case "B":
                    findSpot(1, idOfPlayer);
                    break;
                case "C":
                    findSpot(2, idOfPlayer);
                    break;
                case "D":
                    findSpot(3, idOfPlayer);
                    break;
                case "E":
                    findSpot(4, idOfPlayer);
                    break;
                case "F":
                    findSpot(5, idOfPlayer);
                    break;
                case "G":
                    findSpot(6, idOfPlayer);
                    break;
            }

            winner = isWinner();
            if(winner != -1) {
                clearArray(board);
                return winner == 1 ? "Red" : "Yellow";
            }
        }
        clearArray(board);
        return "";
    }
}