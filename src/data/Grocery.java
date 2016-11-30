package data;


/**
 * Created by Samson on 28-09-2016.
 */
public class Grocery {

    private String name;
    private double prise;

    public Grocery(){

    }

    public Grocery(String name, double prise){
        this.name = name;
        this.prise 	= prise;
    }

    public String getName() {
        return name;
    }

    public String setItem(String item) {
        return item;
    }

    public double getPrise() {
        return prise;
    }

    public double setPrise(double prise) {
        return this.prise = prise;
    }
}
