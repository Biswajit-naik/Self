package tictoctie.model;

public class Player {
    String name;
    PlayingPiece piece;

    public Player(String n,PlayingPiece p){
        this.name = n;
        this.piece = p;
    }

    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public PlayingPiece getPiece(){
        return this.piece;
    }

    public void setPiece(PlayingPiece piece){
        this.piece = piece;
    }
}
