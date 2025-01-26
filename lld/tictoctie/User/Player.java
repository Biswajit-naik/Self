package tictoctie.User;

import tictoctie.SymboTypes;

public class Player implements User {
    String name;
    SymboTypes symbol;

    Player(String name,SymboTypes symbol){
        this.name=name;
        this.symbol=symbol;
    }
    
    public void play(){
        //done business logic
    };
}
