import java.io.IOException;

public class test {

    public static void main(String args[]) {
        Book a = new Book("helo", "helo", "helo", 1);
        System.out.println(a.toString());

        try {
            Press b = new Press("./books", 10);
        } catch (IOException c) {}

        //catch (IllegalAccessException z) {}
        
        
    }
}