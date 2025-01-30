package tictoctie.model;

public class Board {
    int size;
    PlayingPiece [][] board;

    public Board(int size){
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(){
        return true;
    }

    public void getFreeCell(){

    }

    public void printBoard(){
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = " ";
                System.out.print(board[i][j] + "|");
            }
            System.out.println(" ");
        }
    }
}
