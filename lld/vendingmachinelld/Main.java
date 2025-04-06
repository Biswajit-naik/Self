package vendingmachinelld;

import vendingmachinelld.vendingmachinestate.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("filling up the inventory");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);


            System.out.println("Clicking on Insert Button");
            
            State vendingMachinestate = vendingMachine.getVendingmachinestate();
            vendingMachinestate.clickOnInsertCoinButton(vendingMachine);

            vendingMachinestate = vendingMachine.getVendingmachinestate();
            vendingMachinestate.insertCoinVandingMachine(vendingMachine, Coin.NICKEL);
            vendingMachinestate.insertCoinVandingMachine(vendingMachine, Coin.QUARTER);

            System.out.println("clicking on ProductSelectionButton");
            vendingMachinestate.clickOnSelectproductbutton(vendingMachine);

            vendingMachinestate = vendingMachine.getVendingmachinestate();
            vendingMachinestate.chooseProduct(vendingMachine, 101);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage() + e.getStackTrace());
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] itemShelfs = vendingMachine.getInventory().getInventorylist();
        for(int i=0;i< itemShelfs.length;i++){
            Item newItem = new Item();
            if (i >= 0 && i<=3){
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >= 3 && i<= 5){
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=5 && i<7){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }

            itemShelfs[i].setItem(newItem);
            itemShelfs[i].setSoldout(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] itemShelfs = vendingMachine.getInventory().getInventorylist();
        
        for(int i =0; i < itemShelfs.length;i++){
            System.out.println("codeNumber: "+ itemShelfs[i].getItemcode()
             + "Item: " + itemShelfs[i].getItem().getItemType()
             + "Price" + itemShelfs[i].getItem().getPrice()
             + "isAvailable: " + itemShelfs[i].isSoldout());
        }
    }
}
