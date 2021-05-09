/**
 * This method is a subclass of the Mono method, it implements the caesar cipher on each character
 */
public class Caesar extends MonoAlphaSubstitution {

    private static String mapping;
    private int shift;

    public Caesar() {
    }

    /**
     *
     * This constructor is used to create the mapping string which the parent class which can access to then be used
     * in the encryption/decryption methods
     * @param shift, inputted by the user via the command line, this determines the shift.
     */

    public Caesar(int shift) {
        this.shift = shift;
        mapping = getMapping(shift);
    }

    /**
     *
     * @param shift, inputted via the user
     * @return mapping, which is used to encrypt, decrypt the string entered by the user
     */
    public String getMapping(int shift) {
        int i;
        mapping = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (i = 0; i < 52; i++) {
            if (Character.isUpperCase(alphabet.charAt(i))) {
                mapping += "" + alphabet.charAt(i) + (char) ((alphabet.charAt(i) - 'A' + shift % 26 + 26) % 26 + 'A');
            } else if (Character.isLowerCase(alphabet.charAt(i))) {
                mapping += "" + alphabet.charAt(i) + (char) ((alphabet.charAt(i) - 'a' + shift % 26 + 26) % 26 + 'a');
            }
        }
        return mapping;
    }

    /**
     *
     * The main method instantiates a new object of caesar, this object then stores a string which is created inside
     * the constructor, then another object of type MonoAlphaSubstitution is instantiated, by using the string created,
     * the parent class can them treat this as another mono cipher.
     * @param args, args[0] is the selection to encrypt or decrypt, args[1] is the shift and args[2] is the plaintext
     *              or ciphertext of which the user wants to use.
     */

    public static void main(String[] args) {

        if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Caesar encrypt n \"cipher text\"\n");
            return;

        } else if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"\n");
            return;
        }

        if (!(args[0].equals("encrypt") || args[0].equals("decrypt"))){
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Caesar encrypt n \"cipher text\"\n");
            return;
        }

        MonoAlphaSubstitution caesar = new Caesar(Integer.parseInt(args[1]));
        MonoAlphaSubstitution monoAlphaSubstitution = new MonoAlphaSubstitution(mapping);

        if (args[0].equals("encrypt")) {
            System.out.println(monoAlphaSubstitution.encrypt(args[2]));

        } else if (args[0].equals("decrypt")) {
            System.out.println(monoAlphaSubstitution.decrypt(args[2]));
        }
    }
}
