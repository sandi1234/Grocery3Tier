package data.dao;

import data.GroceryList;

import java.util.ArrayList;
import java.util.List;

public class GroceryListDAO {

    private List<GroceryList> database;

    public GroceryListDAO() {
        database = new ArrayList<>();
    }

    public void save(GroceryList groceryList) {
        database.add(groceryList);
    }

    public void update(GroceryList groceryList) {
        database.remove(groceryList);
        database.add(groceryList);
    }

    public void delete(GroceryList groceryList) {
        database.remove(groceryList);
    }

    public List<GroceryList> findAll() {
        return database;
    }
}
