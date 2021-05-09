//Jonathan Ash
//201499939
import java.util.*;


/**
 * This class is used to decipher a text given by the user
 */
public class Brutus {
    public static final double[] english = {
            0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
            0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
            0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    /**
     * @param Ciphertext, called from main
     * @return count of each letter in the text
     */
    public static double[] count(String cipherText) {

        int i;
        double[] letterCount = new double[26]; //Declare new int array
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alpha = alphabet.toCharArray();
        cipherText = cipherText.toLowerCase(); //to make sure all cases are counted

        for (int j = 0; j < cipherText.length(); j++) {
            char ch = cipherText.charAt(j);
            for (i = 0; i < 26; i++) {
                if (ch == alpha[i]) {
                    letterCount[i]++; //Increases counter by 1
                }
            }
        }
        return letterCount;
    }

    /**
     * @param Ciphertext, inputted by the user
     * @return letterFrequency of letters in ciphertext
     */
    public static double[] frequency(String cipherText) {

        int i;
        double[] letterFreq = new double[26]; //Declare new int array
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alpha = alphabet.toCharArray();
        cipherText = cipherText.toLowerCase(); //to make sure all cases are counted
        double cipherLen = cipherText.length();

        //Gives count od the letters in the string
        for (int j = 0; j < cipherText.length(); j++) {
            char ch = cipherText.charAt(j);
            for (i = 0; i < 26; i++) {
                if (ch == alpha[i])
                    letterFreq[i]++;
            }
        }
        // Gives the frequency by dividing the index by the length of text
        for (int k = 0; k < 26; k++) {
            letterFreq[k] = letterFreq[k] / cipherLen;
        }

        return letterFreq;
    }

    /**
     *
     * @param english, frequencies for the occurrences in the english alphabet
     * @param letterFreq, frequency of letters in the ciphertext
     * @return total, returns total chi squared
     */
    public static double chiSquared(double[] english, double[] letterFreq) {

        int i;
        double[] chi = new double[26];
        double total = 0;

        for (i = 0; i < 26; i++) {
            chi[i] = Math.pow((letterFreq[i] - english[i]), 2) / english[i];//Chi score of each element
        }
        for (double z : chi) {
            total += z;
        }
        return total;
    }

    /**
     *
     * @param english, english frequencies
     * @param letterFreq, letter frequencies
     * @param Ciphertext, ciphertext imported from main, from user
     * @return decrypted, returns the decrypted string
     */
    public static String decrypt(double[] english, double[] letterFreq, String cipherText) {

        double value1 = 0;
        double min = 100000;
        double[] value = new double[26];
        int turn = 0;
        String cipher = "";
        String decrypted = "";

        for (int shift = 0; shift < 26; shift++) {
            value[shift] = chiSquared(english, frequency(Caesar.rotate(shift, cipherText)));
            if (value[shift] < min) {
                min = value[shift];
                turn = shift;
            }
        } decrypted = Caesar.rotate(turn, cipherText);
        return decrypted;
    }
        /**
     * This method is used to make sure the args is not null
     * @param args, args entered by the user which is the string to be decrypted
     *
     */
    public static void main (String[]args) {

        if (args.length > 1) {
            System.out.println("Too many parameters!\nUsage: java Brutus \"cipher text\"");
            return;
        } else if (args.length < 1) {
            System.out.println("Too few parameters!\nUsage: java Brutus \"cipher text\"");
            return;
        }
        String cipherText = args[0];

        //output
        double[] letterFreq = frequency(cipherText);
        String decrypted = decrypt(english, letterFreq, cipherText);
        System.out.println(decrypted);

    }
}









































