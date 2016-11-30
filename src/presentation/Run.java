package presentation;

import application.Shop;
import data.GroceryList;

/**
 * Created by Samson on 28-09-2016.
 */

public class Run{

    static Shop shop = new Shop();

    public static void main(String[] args){
        addGroceries();
        System.out.println(shop.seeGroceryStock());

        updateGroceries();
        System.out.println(shop.seeGroceryStock());

        deleteGroceries();
        System.out.println(shop.seeGroceryStock());

        GroceryList list1 = shop.makeGroceryList();
        GroceryList list2 = shop.makeGroceryList();
        GroceryList list3 = shop.makeGroceryList();

        list1.addItem(shop.makeItemOrder(shop.getGroceryByName("Cola"), 3));
        list1.addItem(shop.makeItemOrder(shop.getGroceryByName("Twix"), 6));
        list1.addItem(shop.makeItemOrder(shop.getGroceryByName("Milk"), 1));
        list1.addItem(shop.makeItemOrder(shop.getGroceryByName("Bread"), 2));
        list1.addItem(shop.makeItemOrder(shop.getGroceryByName("Butter"), 1));

        list2.addItem(shop.makeItemOrder(shop.getGroceryByName("Sprite"), 1));
        list2.addItem(shop.makeItemOrder(shop.getGroceryByName("Pancake"), 1)); // no pancakes should null

        list3.addItem(shop.makeItemOrder(shop.getGroceryByName("Fanta"), 2));
        list3.addItem(shop.makeItemOrder(shop.getGroceryByName("Cola"), 2));
        list3.addItem(shop.makeItemOrder(shop.getGroceryByName("Mars"), 2));

        shop.saveGroceryList(list1);
        shop.saveGroceryList(list2);
        shop.saveGroceryList(list3);

        for (GroceryList groceryList : shop.getAllGroceryLists()) {
            System.out.println(shop.getTotalCost(groceryList));
        }


        System.out.println(shop.getTotalCost(list3));
        list3.addItem(shop.makeItemOrder(shop.getGroceryByName("Bread"), 2));
        list3.addItem(shop.makeItemOrder(shop.getGroceryByName("Butter"), 1));
        shop.updateGroceryList(list3);
        System.out.println(shop.getTotalCost(list3));



    }

    private static void addGroceries() {
        shop.addNewGroceryToShop("Fanta", 15);
        shop.addNewGroceryToShop("Cola", 15);
        shop.addNewGroceryToShop("Sprite", 15);
        shop.addNewGroceryToShop("Twix", 5);
        shop.addNewGroceryToShop("Mars", 5);
        shop.addNewGroceryToShop("Snickers", 5);
        shop.addNewGroceryToShop("Bounty", 5);
        shop.addNewGroceryToShop("Milk", 7);
        shop.addNewGroceryToShop("Bread", 12);
        shop.addNewGroceryToShop("Butter", 11);
    }

    private static void updateGroceries() {
        shop.updateGrocery("Twix", 6);
        shop.updateGrocery("Milk", 4);
        shop.updateGrocery("Cola", 20);
    }

    private static void deleteGroceries() {
        shop.deleteGroceryByName("Bounty");
    }
}