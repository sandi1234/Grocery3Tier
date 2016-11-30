package application;

import data.*;
import data.dao.GroceryDAO;
import data.dao.GroceryListDAO;
import java.util.List;

public class Shop {

    private GroceryDAO groceryDAO;
    private GroceryListDAO groceryListDAO;

    public Shop() {
        groceryDAO = new GroceryDAO();
        groceryListDAO = new GroceryListDAO();
    }

    public GroceryItemOrder makeItemOrder(Grocery grocery, int quantity) {
        return new GroceryItemOrder(grocery, quantity);
    }

    public GroceryList makeGroceryList() {
        return new GroceryList();
    }

    public void saveGroceryList(GroceryList groceryList) {
        groceryListDAO.save(groceryList);
    }

    public void deleteGroceryList(GroceryList groceryList) {
        groceryListDAO.delete(groceryList);
    }

    public void updateGroceryList(GroceryList groceryList) {
        groceryListDAO.update(groceryList);
    }

    public List<GroceryList> getAllGroceryLists() {
        return groceryListDAO.findAll();
    }

    public void addNewGroceryToShop(String name, double price) {
        groceryDAO.save(new Grocery(name, price));
    }


    public void deleteGrocery(Grocery grocery) {
        groceryDAO.delete(grocery);
    }

    public void deleteGroceryByName(String name) {
        deleteGrocery(getGroceryByName(name));
    }

    public void updateGrocery(String name, double price) {
        groceryDAO.save(new Grocery(name, price));
    }

    public List<Grocery> getAllGroceries() {
        return groceryDAO.findAll();
    }

    public Grocery getGroceryByName(String name) {
        Grocery grocery = groceryDAO.findByName(name);
        if (grocery == null) {
            grocery = new Grocery();
        }
        return grocery;
    }

    public String seeGroceryStock() {
        String groceryStock = "\nName     Price\n";
        groceryStock        += "--------------\n";
        for (Grocery grocery : groceryDAO.findAll()) {
            groceryStock += grocery.getName() + "      " + grocery.getPrise() + "\n";
        }
        return groceryStock;
    }

    public String getTotalCost(GroceryList groceryList) {
        String total = "\n";
        double sum = 0;

        GroceryItemOrder[] list = groceryList.getList();
        for (int i = 0; i < list.length; i++) {
            GroceryItemOrder groceryItemOrder = list[i];
            if (groceryItemOrder != null) {
                if(groceryItemOrder.getItem().getName() != null) {
                    sum += groceryItemOrder.getItem().getPrise() * groceryItemOrder.getQuantity();
                    total += "Nr. " + (i + 1) + " " + groceryItemOrder.getItem().getName() + " " + groceryItemOrder.getQuantity() + " * " + groceryItemOrder.getItem().getPrise() + "\n";
                }
            }
        }

        return total + "Total Price: " + sum + "\n";
    }
}
