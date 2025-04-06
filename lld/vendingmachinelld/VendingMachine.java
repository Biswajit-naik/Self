package vendingmachinelld;

import java.util.ArrayList;
import java.util.List;

import vendingmachinelld.vendingmachinestate.State;
import vendingmachinelld.vendingmachinestate.Impl.HasMoneyState;
import vendingmachinelld.vendingmachinestate.Impl.IdleState;

public class VendingMachine {
    private State vendingmachinestate;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine(){
        vendingmachinestate = new IdleState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }

    public State getVendingmachinestate() {
        return vendingmachinestate;
    }

    public void setVendingmachinestate(State vendingmachinestate) {
        this.vendingmachinestate = vendingmachinestate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public void setVendingmacineState(HasMoneyState idleState) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVendingmacineState'");
    }

   
}
