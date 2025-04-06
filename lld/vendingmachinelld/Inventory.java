package vendingmachinelld;

public class Inventory {
    private ItemShelf[] inventorylist = null;

    public Inventory(int number) {
        inventorylist = new ItemShelf[number];
        initialInventory();
    }

    public ItemShelf[] getInventorylist() {
        return inventorylist;
    }

    public void setInventorylist(ItemShelf[] inventorylist) {
        this.inventorylist = inventorylist;
    }

    public void initialInventory() {
        int startcode = 101;

        for (int i = 0; i < inventorylist.length; i++) {
            ItemShelf temp = new ItemShelf();
            temp.setItemcode(startcode);
            temp.setSoldout(true);
            inventorylist[i] = temp;
            startcode++;
        }
    }

    public void additem(Item item,int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventorylist){
            if (itemShelf.getItemcode() == codeNumber){
                if(itemShelf.isSoldout()){
                    itemShelf.item=item;
                    itemShelf.setSoldout(false);
                }else{
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventorylist){
            if (itemShelf.getItemcode() == codeNumber){
                if(itemShelf.isSoldout()){
                    throw new Exception("item already sold out");

                }else{
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Code");
    }
    public void updateitem(int codeNumber){
        for (ItemShelf itemShelf : inventorylist) {
            if (itemShelf.getItemcode() == codeNumber) {
                itemShelf.setSoldout(true);
            }
        }
    }


}
