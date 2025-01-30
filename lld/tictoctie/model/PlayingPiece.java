package tictoctie.model;

public class PlayingPiece {

    PlayingPieceType type;

    public PlayingPiece(PlayingPieceType piece) {
        this.type = piece;
    }

    public PlayingPieceType getPieceType(){
        return this.type;
    }

}