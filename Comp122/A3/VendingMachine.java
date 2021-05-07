import java.util.*;
import java.io.*;

/**
 * This class acts as a vending machine where a user can buy a book using the methods below
 */
public class VendingMachine  {
    private Press supplier;
    private double locationFactor;
    private double cassette;
    private double price;
    String path;
    private double total;
    Map<String, Queue<Book>> shelf;
    double value;
    private int size;

    /**
     * 
     * @param supplier, this is the press object which produces the books and adds them to a list 
     * @param locationFactor, this is a multipler to make the price higher or lower based on location
     * @param size, the size of the shelves
     */

    public VendingMachine(Press s, double l, int z) throws FileNotFoundException {
        supplier = s;
        locationFactor = l;
        size = z;
        shelf = new HashMap<>();
        supplier = new Press(supplier.path, size);

        for (String a : supplier.getCatalogue()) {
            shelf.put(a, (LinkedList) supplier.request(a, z));
        }
    }

    public double getCassette(){
       return cassette;
    }

    /**
     * This method is for the user to insert coins 
     * @param c, the coin the user enters everytime
     * @throws IllegalArgumentException
     */
    public void insertCoin(double c) throws IllegalArgumentException {
        double[] values = {0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0};
        int i;
        boolean found = false;

        for (i = 0; i < values.length; i++) {
            if (c == values[i]) {
                found = true;
            } 
        } if (found) {
            value = value + c;
            cassette = value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the total value
     * @return, the total value of the coins, and sets the cassette to 0
     */
    public double returnCoins(){
        cassette = 0;
        return value;
    }

    /**
     * 
     * @param ID, the string of the book, which the user would like 
     * @return book, this returns the book which the user wants
     * @throws CassetteException 
     * @throws IllegalArgumentException
     */
    public Book buyBook(String ID) throws CassetteException, IllegalArgumentException {
        boolean found = false;
        price = (shelf.get(ID).peek().getPages()) * locationFactor;

        if (value > price) {
            if (shelf.get(ID).size() <= 0) {
                supplier.request(ID, size);
            }
        }    
        if (!(shelf.containsKey(ID))) {
            throw new IllegalArgumentException();
        }    
        if (price > total) {
            throw new CassetteException("error");
        }
        return shelf.get(ID).remove();
    }
}
