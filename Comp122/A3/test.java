import java.io.IOException;

public class test {

    public static void main(String args[]) {
        Book a = new Book("helo", "helo", "helo", 1);
        System.out.println(a.toString());

        try {
            Press b = new Press("/home/jash2002/uniWork/gitBackup/Comp122/A3/books", 1);
            System.out.println(b.print("11-0.txt"));
        } catch (IOException c) {}
        }

        
    }