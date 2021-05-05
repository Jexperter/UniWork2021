import jdk.nashorn.internal.ir.CaseNode;

public class VendingMachine  {
    private Press supplier;
    private double locationFactor;
    private double cassette;

    public VendingMachine(Press p, double f, int z) {

    }

    public double getCassette(){
       return cassette;
    }

    public void insertCoin(double c) {
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

    public Book buyBook(String ID) {}
}
