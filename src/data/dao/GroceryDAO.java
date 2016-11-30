package data.dao;

import data.Grocery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samson
 */
public class GroceryDAO {

    private List<Grocery> database;

    public GroceryDAO() {
        database = new ArrayList<>();
    }

    public void save(Grocery grocery) {
        if (findByName(grocery.getName()) != null) {
            delete(findByName(grocery.getName()));
        }
        database.add(grocery);
    }

    public void update(Grocery grocery) {
        save(grocery);
    }

    public void delete(Grocery grocery) {
        database.remove(grocery);
    }

    public List<Grocery> findAll() {
        return database;

    }

    public Grocery findByName(String name) {
        for (Grocery grocery : database) {
            if (grocery.getName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }

}
