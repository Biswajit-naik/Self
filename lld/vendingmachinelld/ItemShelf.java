package vendingmachinelld;

public class ItemShelf {
    int itemcode;
    Item item;
    boolean isSoldout;
    public int getItemcode() {
        return itemcode;
    }
    public void setItemcode(int itemcode) {
        this.itemcode = itemcode;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    
    public boolean isSoldout() {
        return isSoldout;
    }
    public void setSoldout(boolean isSoldout) {
        this.isSoldout = isSoldout;
    }
}
