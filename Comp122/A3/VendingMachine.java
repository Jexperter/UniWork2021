
public class VendingMachine  {
    private Press supplier;
    private double locationFactor;
    private double cassette;
    private double price;

    public VendingMachine(Press p, double f, int z) {
        supplier = p;
        locationFactor = f;
        price = Book.getPages() * f; 
    }

    public double getCassette(){
       return cassette;
    }

    public void insertCoin(double c)throws IllegalArgumentException {
        double[] values = {0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0};
        int i;

        for (i = 0; i < values.length; i++) {
            if (c != values[i]) {
                throw IllegalArgumentException;
            } else {
                cassette = cassette + c;
            }
        }
    }

    public double returnCoins(){
        
        return cassette;
    }

    public Book buyBook(String ID) {

    }
}
