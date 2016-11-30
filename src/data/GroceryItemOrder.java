package data;


/**
 * Created by Samson on 28-09-2016.
 */
public class GroceryItemOrder {


    private Grocery item;
    private int quantity = 1;
    private double toTalPrize;

    public GroceryItemOrder(Grocery item, int quantity){
        this.item 		= item;
        this.quantity 	= quantity;
        this.toTalPrize = quantity * item.getPrise();

    }

    public GroceryItemOrder(){

    }
    public double getToTalPrize() {
        return toTalPrize;
    }

    public void setToTalPrize(double toTalPrize) {
        this.toTalPrize = toTalPrize;
    }


    public Grocery getItem() {
        return item;
    }

    public void setItem(Grocery item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        return quantity;
    }

    public double getCost(){
        return toTalPrize;
    }

    @Override
    public String toString() {
        return "data.GroceryItemOrder{" +
                "item=" + item.getName() +
                ", quantity=" + quantity +
                ", toTalPrize=" + toTalPrize +
                '}';
    }
}