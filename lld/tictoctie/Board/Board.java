package tictoctie.Board;

public class Board {
    int size[][];

    public Board(int size) throws Exception{
        if (size <= 3)
            throw new IllegalArgumentException("Size must be greater than 0.");

        this.size=new int[size][size];
    }

}
