package vendingmachinelld.vendingmachinestate.Impl;

import java.util.ArrayList;
import java.util.List;

import vendingmachinelld.VendingMachine;
import vendingmachinelld.Coin;
import vendingmachinelld.Item;
import vendingmachinelld.vendingmachinestate.State;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingmachinestate(new HasMoneyState());
    }

    @Override
    public void clickOnSelectproductbutton(VendingMachine machine) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickOnSelectproductbutton'");
    }

    @Override
    public void insertCoinVandingMachine(VendingMachine machine, Coin coin) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCoinVandingMachine'");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) throws Exception {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refundFullMoney'");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().additem(item, codeNumber);
    }

}
