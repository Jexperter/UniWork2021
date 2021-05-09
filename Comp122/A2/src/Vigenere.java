import java.util.*;

/**
 * This method implements the Vigenere cipher. It creates concreate implementations of the abstract class
 */

public class Vigenere extends Substitution {

    private String key;
    private String[] phrase;
    final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int count = 0;
    private int shift;

    public Vigenere() {
        shift = 0;
        String[] phrase = {"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    }

    /**
     *
     * @param key, the key entered by the user in the terminal. This constructor is used to set up a vigenere object.
     */
    public Vigenere(String key) {
        this.key = key.toUpperCase();
        phrase = getPhrase();
    }
    /**
     * This method creates 26 possible shifts on the alphabet
     * @return phrase, this returns the string array which is created via this method
     */
    public String[] getPhrase() {
        int i, j;
        phrase = new String[27];
        Arrays.setAll(phrase, k -> "");

        for (i = 0; i < 26; i++) {
            for (j = 0; j < 52; j++) {
                if (Character.isUpperCase(alphabet.charAt(j))) {
                    phrase[i] += (char) ((alphabet.charAt(j) - 'A' + i % 26 + 26) % 26 + 'A');
                } else if (Character.isLowerCase(alphabet.charAt(j))) {
                    phrase[i] += (char) ((alphabet.charAt(j) - 'a' + i % 26 + 26) % 26 + 'a');
                }
            }
        }
        return phrase;
    }

    /**
     * This method implements the abstract methods from the parent class.
     * @param c, each character inside the strring entered by the user
     * @return b, this is the encrypted character.
     */
    @Override
    public char encrypt(char c) {

        char b = ' ';
        //Find index of letter in alphabet
        if (key.equals("")) {
            b = c;
            return b;

        } else {
            int i, index;

            for (i = 0, index = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == c) {
                    index = i;
                }
            }

            //Find shift of of cipher
            if (Character.isAlphabetic(c)) {
                shift = (key.charAt(count) - 'A');
                b = phrase[shift++].charAt(index);
                count++;
            } else {
            b = c;
            count++;
        }
        if (count == key.length()) {
            count = 0;
        }
    }
    return b;
    }

    /**
     * @param c, each letter inside the cryptotext
     * @return b, which is the decrypted character according the vigenere cipher
     */
    @Override
    public char decrypt(char c) {

        char b = ' ';
        if (key.equals("")) {
            b = c;
            return b;
        } else {

        //Find index of letter in alphabet
        int i, index;

            shift = 'A' - key.charAt(count);
            for (i = 0, index = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == c) {
                    index = i;
                }
            }

            //Find shift of of cipher
            if (Character.isAlphabetic(c)) {
                b = phrase[26+shift].charAt(index);
                count++;
            } else {
                b = c;
                count++;
            }
            if (count == key.length()) {
                count = 0;
            }
        }
    return b;
    }
    /**
    * This main class is outside the object and allows for the class to be used
    * @param args, these are the selction, cryptotext/plaintext and the key. These are all entered by the user via the command line
    */
    public static void main(String[] args) {

        if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Vigenere encrypt key \"cipher text\"\n");
            return;

        } else if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Vigenere encrypt key \"cipher text\"\n");
            return;
        }

        if (!(args[0].equals("encrypt") || args[0].equals("decrypt"))){
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Vigenere encrypt key \"cipher text\"\n");
            return;
        }

        Vigenere a = new Vigenere(args[1]);

        if (args[0].equals("encrypt")) {
            System.out.println(a.encrypt(args[2]));


        } else if (args[0].equals("decrypt")) {
            System.out.println(a.decrypt(args[2]));
        }


    }
}
