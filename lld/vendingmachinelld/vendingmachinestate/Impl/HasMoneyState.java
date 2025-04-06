package vendingmachinelld.vendingmachinestate.Impl;

import java.util.List;

import vendingmachinelld.Coin;
import vendingmachinelld.Item;
import vendingmachinelld.VendingMachine;
import vendingmachinelld.vendingmachinestate.State;

public class HasMoneyState implements State{

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        // TODO Auto-generated method stub
        return;
    }

    @Override
    public void clickOnSelectproductbutton(VendingMachine machine) throws Exception {
        machine.setVendingmachinestate(new SelectionState());
    }

    @Override
    public void insertCoinVandingMachine(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'chooseProduct'");
    }

    @Override
    public int getChange(int returnmoney) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChange'");
    }

    @Override
    public Item dispanceItem(VendingMachine machine, int codeNumber) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispanceItem'");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingmachinestate(new IdleState());
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInventory'");
    }
    
}
