package vendingmachinelld.vendingmachinestate.Impl;

import java.util.List;

import vendingmachinelld.Coin;
import vendingmachinelld.Inventory;
import vendingmachinelld.Item;
import vendingmachinelld.VendingMachine;
import vendingmachinelld.vendingmachinestate.State;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickOnInsertCoinButton'");
    }

    @Override
    public void clickOnSelectproductbutton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoinVandingMachine(VendingMachine machine, Coin coin) throws Exception {
        // TODO Auto-generated method stub
        throw new Exception("you can not insert Coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) throws Exception {
        Item item=machine.getInventory().getItem(code);

        //check the price
        int sum =0;
        for (Coin coin :machine.getCoinList()){
               sum = sum + coin.value;
        }

        if (sum < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + sum);
            refundFullMoney(machine);
            throw new Exception("Insufficinet Ammount");
        }else if(sum >= item.getPrice()){
            if (sum > item.getPrice()){
                getChange(sum-item.getPrice());
            }
            machine.setVendingmachinestate(new DispanceState(machine, code));
        }
    }

    @Override
    public int getChange(int returnmoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnmoney);
        return returnmoney;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInventory'");
    }

}