package data;

/**
 * Created by Samson on 14-09-2016.
 */
public class GroceryList {

    private GroceryItemOrder[] list;
    private int count = 0;

    public GroceryList() {
        list = new GroceryItemOrder[10];
    }

    public void addItem(GroceryItemOrder item){
        if(count >=10){
            System.out.println("List is full");
        } else {
            list[count] = item;
            count++;
        }
    }

    public GroceryItemOrder[] getList() {
        return list;
    }
}