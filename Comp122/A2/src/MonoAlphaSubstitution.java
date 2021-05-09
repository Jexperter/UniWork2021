/**
 * This class is a sub-class of Substitution, it uses two constructors, 2 overrided abstract methods and a main method which
 * takes in arguments from the command line
 */

public class MonoAlphaSubstitution extends Substitution {

    public String mapping;

    public  MonoAlphaSubstitution() {
        mapping = "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzzAABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ";
    }

    public MonoAlphaSubstitution(String newMapping) {
        mapping = newMapping;
    }

    /**
     *
     * @param c, this takes every character of the plaintext variable to encrypts it
     * @return b, this is the encrypted character which is then used to form the encrypted string
     */

    @Override
    public char encrypt(char c) {
        int j;
        char[] mappingArr = mapping.toCharArray();
        char b = ' ';

        if (mapping.equals("")) {
            return c;
        }

        else {
            for (j = 0; j < mappingArr.length; j = j + 2) {
                if (mappingArr[j] == c) {
                    b = mappingArr[j + 1];
                    break;
                } else {
                    b = c;
                }
            }
        }
        return b;
    }

    /**
     *
     * @param c, this takes every character of the cryptotext variable and decodes it
     * @return b, this is the decrypted character which is then used to form the decrypted String
     */
    @Override
    public char decrypt(char c) {
        int j;
        char[] mappingArr = mapping.toCharArray();
        char b = ' ';

        if (mapping.equals("")) {
            return c;
        }
        else {
            for (j = 1; j < mappingArr.length; j = j + 2) {
                if (mappingArr[j] == c) {
                    b = mappingArr[j - 1];
                    break;
                } else {
                    b = c;
                }
            }
        }
        return b;
    }

    /**
     *
     * @param args, the user will enter 3 arguments, these being args[1] = selection, args[2] = mapping, args[3] =
     *              the plaintext or cryptotext
     */

    public static void main(String[] args) {



        if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"\n");
            return;

        } else if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"\n");
            return;
        }

        if (!(args[0].equals("encrypt") || args[0].equals("decrypt"))){
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"\n");
            return;
        }

        MonoAlphaSubstitution a = new MonoAlphaSubstitution();
        MonoAlphaSubstitution b = new MonoAlphaSubstitution(args[1]);
        if (args[0].equals("encrypt")) {
            System.out.println(b.encrypt(args[2]));
        } else if (args[0].equals("decrypt")) {
            System.out.println(b.decrypt(args[2]));
        }
    }
}