package vendingmachinelld.vendingmachinestate;

import java.util.List;

import vendingmachinelld.Coin;
import vendingmachinelld.Item;
import vendingmachinelld.VendingMachine;

public interface State {
    void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    void clickOnSelectproductbutton(VendingMachine machine) throws Exception;

    void insertCoinVandingMachine(VendingMachine machine, Coin coin) throws Exception;

    void chooseProduct(VendingMachine machine, int code) throws Exception;

    int getChange(int returnmoney) throws Exception;

    Item dispanceItem(VendingMachine machine, int codeNumber) throws Exception;

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
