import java.io.IOException;

public class test {

    public static void main(String args[]) {
        Book a = new Book("helo", "helo", "helo", 1);
        System.out.println(a.toString());

        try {
            Press b = new Press("/home/jash2002/uniWork/gitBackup/Comp122/A3/books", 2);
            System.out.println(b.toString());
        } catch (IOException c) {}
        
    }
}