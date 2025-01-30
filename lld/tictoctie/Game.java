package tictoctie;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tictoctie.model.Board;
import tictoctie.model.Player;
import tictoctie.model.PlayingPiece;
import tictoctie.model.PlayingpieceO;
import tictoctie.model.PlayingpieceX;

public class Game {
    Deque<Player> user;
    Board board;

    public Game(){
        this.user= new LinkedList<>();
        initialize();
    }
    
    private void initialize() {  
       PlayingpieceX crosspiece = new PlayingpieceX();
       Player user1 = new Player("biswajit",crosspiece);

       PlayingpieceO ovalpiece = new PlayingpieceO();
       Player user2 = new Player("ram",ovalpiece);

       board = new Board(3);

       user.add(user1);
       user.add(user2);
    }

    public void start(){
        System.out.println("Game started");
        boolean nowinner = true;

        while (nowinner) {
            Player currturn = user.poll();
            PlayingPiece curr = currturn.getPiece();
            //print the free space 
            board.printBoard();
            System.out.println(currturn.getName()+" your turn :"+ (curr.getPieceType()).toString());

            board.addPiece();

        }
    }
    
    
}
