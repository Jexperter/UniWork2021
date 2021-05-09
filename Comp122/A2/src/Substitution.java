/**
 *This abstract class is used to declare non-implemented methods which can then be implemented in the sub classes below
 */

public abstract class Substitution implements Cipher {

    /**
     * @param c, when implemented this will be for every character
     * @return, when implemented, it will return the encrypted character
     */

    public abstract char encrypt(char c);

    /**
     *
     * @param c, when implemented, this will be for every character inside the string
     * @return, when implemented, it will return the decrypted character
     */

    public abstract char decrypt(char c);

    /**
     *
     * @param plaintext, the user enters this via the command line
     * @return cryptotext, this is the encrypted string by using the plaintext param which uses the previous abstract methods
     */

     public String encrypt(String plaintext) {
        int i;
        String cryptotext = "";
        for (i = 0; i < plaintext.length(); i++) {
            cryptotext += encrypt(plaintext.charAt(i));
        }
        return cryptotext;
    }

    /**
     *
     * @param cryptotext, this is entered by the user via the command line
     * @return plaintext, this is the decrypted version of the cryptotext param which uses the previous abstract method
     */

     public String decrypt(String cryptotext) {
        int i;
        String plaintext = "";
        for (i = 0; i < cryptotext.length(); i++) {
            plaintext += decrypt(cryptotext.charAt(i));
        }
        return plaintext;
    }

}
